USE project_ass6;

-- Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp
-- lệ
-- (Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
-- Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn)
DROP TRIGGER IF EXISTS chek_infor;

DELIMITER $$
CREATE TRIGGER chek_infor 
BEFORE INSERT ON Project_Modules
FOR EACH ROW
BEGIN
	
    DECLARE v_start_date DATETIME;
    DECLARE v_Completed_On DATETIME;
    DECLARE v_ DATETIME;
    -- LAY GIA TRI v_start_date
    SELECT ProjectStartDate 
    INTO v_start_date 
    FROM Project
    WHERE ProjectID = NEW.ProjectID;
    -- LAY GIA TRI v_Completed_On
	SELECT ProjectCompletedOn
    INTO v_Completed_On
    FROM Project
    WHERE ProjectID = NEW.ProjectID;
    -- lay ra gia trị v_projecetID
	if(v_start_date  >  NEW.ProjectModulesDate OR v_Completed_On < NEW.ProjectModulesCompletedOn ) THEN
    SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'tien dep zai';
    end if; 
END$$
DELIMITER ;

insert into project_modules
value  ('P001C',	'P001',		'NEU001',	'2018-07-30',	'2019-07-30',	'lam frontend');


-- Trong database phần Assignment 3, Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là
-- ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số
-- điểm như sau:

USE quanlyfresher;



CREATE OR REPLACE VIEW v_student_infor 
AS
SELECT TraineeID, Full_Name, Birth_Date, Gender
FROM quanlyfresher.trainee
WHERE ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18 AND (ET_IQ + ET_Gmath)>=20;

