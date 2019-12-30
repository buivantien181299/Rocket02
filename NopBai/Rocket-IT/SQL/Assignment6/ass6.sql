DROP DATABASE IF EXISTS Project_ass6;
CREATE DATABASE IF NOT EXISTS Project_ass6;

USE Project_ass6;

DROP TABLE IF EXISTS Employee;
CREATE TABLE IF NOT EXISTS Employee
(
	EmployeeID							CHAR(10) PRIMARY KEY NOT NULL,
    EmployeeLastName					VARCHAR(30)	NOT NULL,
    EmployFirstName						VARCHAR(30) NOT NULL,
    EmPloyeeHireDate					DATETIME NOT NULL,
    EmployeeStatus						NVARCHAR(50) NOT NULL,
    SupervisorID						CHAR(10) NOT NULL,
    SocialSecurityNumber				INT NOT NULL
);

DROP TABLE IF EXISTS Project;
CREATE TABLE IF NOT EXISTS Project
(
	ProjectID							CHAR(10) PRIMARY KEY NOT NULL,
    EmployeeID							CHAR(10) NOT NULL,
    ProjectName							VARCHAR(50) NOT NULL,
    ProjectStartDate					DATETIME NOT NULL,
    ProjectDescription					NVARCHAR(50) NOT NULL,
    ProjectDetailt						NVARCHAR(50) NOT NULL,
    ProjectCompletedOn					DATETIME,
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) 
);


DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE IF NOT EXISTS Project_Modules
(
	ModuleID							CHAR(10) PRIMARY KEY NOT NULL,
    ProjectID							CHAR(10) NOT NULL,
    EmployeeID							CHAR(10) NOT NULL,
    ProjectModulesDate					DATETIME NOT NULL,
    ProjectModulesCompletedOn			DATETIME ,
    ProjectModulesDescription 			NVARCHAR(50) NOT NULL,
    FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID) ,
	FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) 
);


DROP TABLE IF EXISTS Work_Done;
CREATE TABLE IF NOT EXISTS Work_Done
(
	WorkDoneID							CHAR(10) PRIMARY KEY NOT NULL,
    EmployeeID							CHAR(10) NOT NULL,
    ModuleID							CHAR(10) NOT NULL,
    WorkDoneDate						DATETIME,
    WorkDoneDescription					NVARCHAR(50) ,
    WorkDoneStatus						NVARCHAR(50) NOT NULL ,
    FOREIGN KEY (ModuleID) REFERENCES Project_Modules(ModuleID) ,
	FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

INSERT INTO Employee
				(EmployeeID, EmployeeLastName, EmployFirstName, EmPloyeeHireDate, EmployeeStatus, SupervisorID, SocialSecurityNumber)
VALUES
				('NEU001',	'bui',				'tien',			'1999-12-18',	'dang lam viec',	'SV001',	181299),
                ('NEU002',	'pham',				'long',			'1997-10-18',	'dang lam viec',	'SV002',	181097),
                ('NEU003',	'do',				'luong',		'1999-06-17',	'khong lam viec',	'SV001',	170699),
                ('NEU004',	'minh',				'vuong',		'1998-05-10',	'dang lam viec',	'SV003',	151098),
                ('NEU005',	'lan',				'anh',			'1998-07-20',	'dang lam viec',	'SV003',	180798),
                ('NEU006',	'tat',				'thanh',		'1997-10-10',	'khong lam viec',	'SV001',	101297),
                ('NEU007',	'cao',				'thao',			'1999-12-15',	'dang lam viec',	'SV002',	151299),
                ('NEU008',	'cao',				'trang',		'1997-10-21',	'dang lam viec',	'SV001',	211097),
                ('NEU009',	'tien',				'dat',			'1999-05-05',	'dang lam viec',	'SV003',	050599),
                ('NEU010',	'vuong',			'hieu',			'1999-03-02',	'dang lam viec',	'SV002',	303299);
                
INSERT INTO Project
				(ProjectID,	EmployeeID,	ProjectName,ProjectStartDate,ProjectDescription,ProjectDetailt,ProjectCompletedOn)
VALUES			
				('P001',	'NEU001',	'xay dung web',		'2019-05-27', 'lam web ban hang',		'lam full stack',		'2019-10-18'),
                ('P002',	'NEU002',	'xay dung data',	'2019-08-01', 'lam data ban hang',		'lam chi tiet',			'2020-11-21'),
                ('P004',	'NEU004',	'xay dung mo hinh',	'2018-01-01', 'lam mo hinh ban hang',	'lam mo hinh dep',		'2018-12-26');
                
INSERT INTO 	Project_Modules
				(ModuleID, ProjectID,	EmployeeID,	ProjectModulesDate,	ProjectModulesCompletedOn,	ProjectModulesDescription)
VALUES			
				('P001A',	'P001',		'NEU001',		'2019-07-30',	'2019-07-30',	'lam frontend'),
                ('P001B',	'P001',		'NEU001',		'2019-10-17',	'2019-10-18',	'lam backend'),
                ('P002A',	'P002',		'NEU002',		'2019-10-01',	'2020-10-02',	'lam data nhan vien'),
                ('P002B',	'P002',		'NEU002',		'2019-11-20',	NULL		,	'lam data khach hang'),
                ('P004A',	'P004',		'NEU004',		'2018-01-01',	'2018-07-20',	'lam mo hinh sao'),
                ('P004B',	'P004',		'NEU004',		'2018-07-20',	'2018-12-26',	'lam mo hinh sao');
                
INSERT INTO 	Work_Done
				(WorkDoneID,	EmployeeID,	ModuleID,	WorkDoneDate,	WorkDoneDescription,	WorkDoneStatus)
VALUES
				('A001',	'NEU001',	'P001A',	'2019-07-30'	,	'Kha kho',		'can sua lai'),
                ('A002',	'NEU001',	'P001B',	'2019-10-18'	,	'kho vo cung',	'can sua lai'),
                ('A003',	'NEU002',	'P002A',	'2019-10-02'	,	'co ve de',		'khong can sua'),
                ('A004',	'NEU006',	'P002B',	'2019-10-10'	,	'co ve de',		'khong can sua'),
                ('A007',	'NEU002',	'P002B',	'2019-10-03'	,	'co ve de',		'khong can sua'),
                ('A005',	'NEU004',	'P004A',	'2018-07-20'	,	'cung tam',		'can chinh sua'),
                ('A006',	'NEU004',	'P004B',	'2018-12-26'	,	'co ve kho',	'can xem xet');
             
/* 
Viết stored procedure (không có parameter) để Remove tất cả thông tin
project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã
remove từ các table liên quan trong khi removing (dùng lệnh print)
*/



DROP PROCEDURE IF EXISTS   project_complete;
DELIMITER $$
CREATE PROCEDURE project_complete ()

BEGIN 
    
	SELECT 	CONCAT( COUNT(wd.WorkDoneID), " là số dòng bản ghi trong bảng Work_Done bị xóa") AS tb_Work_Done,
			CONCAT( COUNT(pm.ModuleID), " là số dòng bản ghi trong bảng Project_Modules bị xóa") AS tb_Project_Modules,
            CONCAT( COUNT(distinct(p.ProjectID)), " là số dòng bản ghi trong bảng Project bị xóa") AS tb_Project 
	FROM 	Project p
			JOIN 
            Project_Modules pm ON pm.ProjectID = p.ProjectID
            JOIN
            Work_Done wd ON wd.ModuleID = pm.ModuleID
	WHERE
			SUBDATE(CURDATE(), INTERVAL 90 DAY) > P.ProjectCompletedOn;
   
DELETE FROM Work_Done 
WHERE
    ModuleID IN (SELECT 
        ModuleID
    FROM
        Project_Modules
    
    WHERE
        ProjectID IN (SELECT 
            ProjectID
        FROM
            Project
        
        WHERE
            SUBDATE(CURDATE(), INTERVAL 90 DAY) > Project.ProjectCompletedOn));
 
DELETE FROM Project_Modules 
WHERE
    ProjectID IN (SELECT 
        ProjectID
    FROM
        Project
    
    WHERE
        SUBDATE(CURDATE(), INTERVAL 90 DAY) > Project.ProjectCompletedOn);

DELETE FROM Project
    WHERE SUBDATE(CURDATE(), INTERVAL 90 DAY) >Project.ProjectCompletedOn;
END $$
DELIMITER ;
    
CALL project_complete ();



-- Viết stored procedure (có parameter) để in ra các module đang được thực hiện)
DROP PROCEDURE IF EXISTS modules_is_null;
DELIMITER $$
CREATE PROCEDURE modules_is_null ()
	BEGIN
		SELECT 
    ModuleID
	FROM
    Project_Modules
WHERE
	ProjectModulesCompletedOn IS NULL;
	END $$
 DELIMITER ;
CALL  modules_is_null();




/*
Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc
dù không ai giao việc cho nhân viên đó (trong bảng Works) 
*/
DROP FUNCTION IF EXISTS infor_emp;

SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
CREATE FUNCTION infor_emp() RETURNS CHAR(10)
BEGIN
	DECLARE v_EmployeeID CHAR(10);

         SELECT wd.EmployeeID INTO v_EmployeeID
		FROM Work_Done wd
		LEFT JOIN Project_Modules pm  ON pm.ModuleID = wd.ModuleID
		WHERE wd.EmployeeID NOT IN (SELECT EMPLOYEEID FROM PROJECT_MODULES ) LIMIT 1; 
        
		RETURN v_EmployeeID;
END $$
DELIMITER ;

select infor_emp();

