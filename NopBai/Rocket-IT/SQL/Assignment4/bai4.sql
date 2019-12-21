DROP DATABASE IF EXISTS ass4;
CREATE DATABASE IF NOT EXISTS ass4;
USE ass4;
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department
(
	Department_number			TINYINT AUTO_INCREMENT PRIMARY KEY,
    Department_Name				NVARCHAR(30) NOT NULL
); 

INSERT INTO Department 
				(Department_Name)
VALUES
				('Phòng kế toán'),
                ('Phòng kiểm toán'),
                ('Phòng dịch vụ'),
                ('Phòng thu ngân'),
                ('Phòng thủ quỹ'),
                ('Phòng công nghệ'),
                ('Phòng bảo vệ'),
                ('Phòng nhân viên'),
                ('Phòng abc'),
                ('Phòng bdgf');



 
DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE IF NOT EXISTS Employee_Table
(
	Employee_number			CHAR(10) NOT NULL PRIMARY KEY,
    Employee_name			NVARCHAR(30) NOT NULL,
    Department_number		TINYINT,
    FOREIGN KEY (Department_number)  REFERENCES Department (Department_number)
);

INSERT INTO Employee_table 
			(Employee_number, Employee_name, Department_number)
VALUES
			('a001',	'Bùi Văn Tiến',		1),
            ('a002',	'Hà Thị Nguyệt',	3),
            ('a003',	'Nguyễn Tất Thành',	4),
            ('a004',	'Vũ Quốc Vương',	5),
            ('a005',	'Vũ Quốc Hoàn',		6),
            ('a006',	'Cao Thu Trang',	7),
            ('a007',	'Vũ Thu Hằng',		8),
            ('a008',	'Cao Thiên TRang',	1),
            ('a009',	'Võ Hoàng Yến',		2),
            ('a010',	'Kỳ Duyên',			3);
            
 DROP TABLE IF EXISTS Employee_Skill_Table;
 CREATE TABLE IF NOT EXISTS Employee_Skill_Table 
 (
	Skill_Code			CHAR(20) NOT NULL PRIMARY KEY,
    Date_Registered		DATE,
    Employee_number		CHAR(10) NOT NULL,
    FOREIGN KEY(Employee_number) REFERENCES Employee_Table (Employee_number)
 );
 
 INSERT INTO	Employee_Skill_Table
			(Skill_Code,	Date_Registered,	Employee_number)
VALUES
			('javar',	'2000-12-01',	'a001'),
            ('python',	'2001-10-25',	'a005'),
            ('c++',		'1999-12-18',	'a007'),
            ('javars',	'2000-12-01',	'a002'),
            ('javard',	'2000-12-01',	'a003'),
            ('pythonf',	'2000-12-01',	'a002'),
            ('pythong',	'2000-12-01',	'a001'),
            ('javarh',	'2000-12-01',	'a008'),
            ('javary',	'2000-12-01',	'a010'),
            ('c++i',	'2000-12-01',	'a009');
            
-- Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java

SELECT
	et.employee_number,
    et.employee_name,
	est.skill_code
FROM	
	Employee_Table et
    JOIN
	Employee_Skill_Table est ON est.employee_number = et.employee_number
WHERE
	skill_code = 'javar';

-- Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT 	
	d.Department_Name,
    COUNT(eb.Employee_Number) as Tong
FROM
	Department d
    JOIN
    Employee_Table eb ON d.Department_Number = eb.Department_Number
GROUP BY 
	d.Department_Number
HAVING 	
	Tong > 3;

	
-- Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 

SELECT
	d.Department_Name,
    et.Employee_Name
FROM
	Department d
    JOIN
    Employee_Table et ON et.Department_Number = d.Department_Number
GROUP BY 
	d.Department_Number;
    
-- Viết lệnh để lấy ra danh sách nhân viên có >= 1 skills

SELECT 
	 et.Employee_Name,
     COUNT(Skill_Code) AS tong_skill,
     Skill_Code
FROM
	Employee_Skill_Table est
    JOIN
    Employee_table et ON est.Employee_Number = et.Employee_Number

GROUP BY 
	et.Employee_Number
HAVING 
	tong_skill >1;