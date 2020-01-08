DROP DATABASE IF EXISTS QuanLySinhVien;
CREATE DATABASE IF NOT EXISTS QuanLySinhVien;

USE QuanLySinhVien;

DROP TABLE IF EXISTS Students;
CREATE TABLE IF NOT EXISTS Students
(
	RN		CHAR(10) NOT NULL PRIMARY KEY,
    Name	VARCHAR(40) NOT NULL,
    Age		CHAR(3) NOT NULL,
    Gender	ENUM('0' , '1', 'Unknow')
);

INSERT INTO Students
		(RN, Name, Age, Gender)
VALUES
		('SV001',	'Bui Van Tien',	    '21',	'0'),
        ('SV002',	'Ha Van Tien',	    '22',	'1'),
        ('SV003',	'Nguyen Van Tien',	'20',	'Unknow');

DROP TABLE IF EXISTS Subjects;
CREATE TABLE IF NOT EXISTS Subjects
(
	SID		CHAR(10) NOT NULL PRIMARY KEY,
	SName	NVARCHAR(50) NOT NULL
);

INSERT INTO Subjects
		(SID,	SName)
VALUES
		('KTS',	'Ky Thuat So'),
        ('OOP',	'Huong Doi Tuong'),
        ('MMT',	'Mang May Tinh');

DROP TABLE IF EXISTS StudentSubjects;
CREATE TABLE IF NOT EXISTS StudentSubjects
(
	RN		CHAR(10) NOT NULL,
    SID		CHAR(10) NOT NULL,
    Mark	TINYINT NOT NULL,
    SSDate	DATE NOT NULL,
    PRIMARY KEY (RN, SID),
    FOREIGN KEY (RN)  REFERENCES Students(RN),
    FOREIGN KEY (SID) REFERENCES Subjects(SID)
);

INSERT INTO StudentSubjects
		(RN,	SID,	Mark,	SSDate)
VALUES
		('SV001',	'OOP',	'9',	'2018-07-12'),
        ('SV001',	'KTS',	'8',	'2018-07-12'),
        ('SV001',	'MMT',	'8',	'2018-07-12'),
        ('SV002',	'OOP',	'5',	'2019-09-12'),
        ('SV002',	'MMT',	'2',	'2019-09-12');
  
-- Lấy tất cả các môn học không có bất kì điểm nào.
SELECT s.RN, s.Name
FROM Students s
	LEFT JOIN
	StudentSubjects ss ON ss.RN = s.RN
WHERE ss.RN IS NULL;

-- Lấy danh sách các môn học có ít nhất 2 điểm.

SELECT s.SID, s.SName
FROM 	Subjects s
	JOIN
		StudentSubjects ss ON ss.SID = s.SID
GROUP BY  s.SID 
HAVING COUNT(Mark) >= 2;

/*
Tạo "StudentInfo" view có các thông tin về học sinh bao gồm:
RN,sID,Name, Age, Gender, sName, Mark, Date. Với cột Gender show
Male để thay thế cho 0, Female thay thế cho 1 và Unknow thay thế cho
null. 
*/

DROP VIEW IF EXISTS V_StudentInfo;
CREATE VIEW V_StudentInfo 
AS
SELECT st.RN, su.SID, st.Name, st.Age, st.Gender, su.sName, ss.Mark, ss.SSDate
FROM 	Students st
			LEFT JOIN
		StudentSubjects ss ON ss.RN = st.RN
			LEFT JOIN
        Subjects su ON ss.SID = su.SID;
        
/*
Trigger CasUpdate: khi thay đổi data của cột sID, thì giá trị của
cột sID của table StudentSubject cũng thay đổi theo
*/

DROP TRIGGER IF EXISTS t_CasUpdate;

DELIMITER $$
CREATE TRIGGER t_CasUpdate
AFTER UPDATE ON Subjects
FOR EACH ROW
	BEGIN
    UPDATE StudentSubjects 
		SET 
			SID = NEW.SID
		WHERE
			SID = OLD.SID;
    END $$
    
DELIMITER ;

UPDATE Subjects SET SID = 'OPP' WHERE SID = 'OOP';

/*
Trigger casDel: Khi xóa 1 student, các dữ liệu của table
StudentSubject cũng sẽ bị xóa theo
*/
DROP TRIGGER IF EXISTS t_casDel;

DELIMITER $$
CREATE TRIGGER t_casDel
BEFORE   DELETE ON Students
FOR EACH ROW
	BEGIN
		DELETE FROM StudentSubjects
        WHERE RN = OLD.RN;
    END $$
DELIMITER ;

DELETE FROM Students WHERE RN= 'SV002';

/*
Viết 1 thủ tục (có 2 parameters: student name, mark). Thủ tục sẽ xóa tất cả
các thông tin liên quan tới học sinh có cùng tên như parameter và tất cả
các điểm nhỏ hơn của các học sinh đó.
Trong trường hợp nhập vào "*" thì thủ tục sẽ xóa tất cả các học sinh
*/
DROP PROCEDURE IF EXISTS p_delete_infor;

DELIMITER $$
CREATE PROCEDURE p_delete_infor (in Name_su VARCHAR(40), in Mark_ss TINYINT)
	BEGIN
        IF(Name_su = '*') THEN
			DELETE FROM Students;
        ELSE  
			DELETE FROM Students WHERE Name = Name_su;
			DELETE FROM StudentSubjects WHERE Mark < Mark_ss;
        END IF;
    END $$
DELIMITER ;