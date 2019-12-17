-- Bài 1:

DROP DATABASE IF EXISTS quanlyfresher;
CREATE DATABASE IF NOT EXISTS quanlyfresher;

USE quanlyfresher;

-- question1: create table Trainee

DROP TABLE IF EXISTS Trainee;
CREATE TABLE			Trainee
(
		TraineeID 					SMALLINT AUTO_INCREMENT PRIMARY KEY,
        Full_Name					NVARCHAR(30) NOT NULL,
        Birth_Date					DATE NOT NULL,
        Gender						ENUM('male','female','unknown'),
        ET_IQ						TINYINT CHECK ((ET_IQ >= 0) AND (ET_IQ <=20)) NOT NULL,
        ET_Gmath					TINYINT CHECK ((ET_GMATH >= 0) AND (ET_GMATH <=20)) NOT NULL,
        ET_English					TINYINT CHECK ((ET_ENGLISH >= 0) AND (ET_ENGLISH <=50)) NOT NULL,
        Training_Class  			CHAR(10) NOT NULL,
        Evaluation					NVARCHAR(200)
);

-- question2: them truong VTI 

ALTER TABLE Trainee 
	ADD VTI_Account  NVARCHAR(30)  NOT NULL UNIQUE; 
    
    

-- bài 2: 

DROP DATABASE IF EXISTS bai2;
CREATE DATABASE IF NOT EXISTS bai2;

USE bai2;

DROP TABLE IF EXISTS 	Modified;
CREATE TABLE			Modified
(
	ID					MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
    Name_ID 			NVARCHAR(30) NOT NULL,
    Code_ID				TINYINT CHECK (Code_ID >= 0 && Code_ID <= 5) NOT NULL,
    ModifiedDate		DATETIME NOT NULL
);	
 
 
-- bài 3:

DROP DATABASE IF EXISTS bai3;
CREATE DATABASE IF NOT EXISTS bai3;

USE bai3;

DROP TABLE IF EXISTS Birthday;
CREATE TABLE			Birthday
(
	ID					MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
    Name_ID				NVARCHAR(30) NOT NULL,
    Birth_Day_ID		DATE NOT NULL,
    Gender_ID			ENUM('Male', 'Female', 'Unknown'),
    IsDeletedFlag		BIT 
);

 