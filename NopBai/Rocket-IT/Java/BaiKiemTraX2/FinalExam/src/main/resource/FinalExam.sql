-- =============================================
-- Create database
-- =============================================

-- Drop the database if it already exists
DROP DATABASE IF EXISTS FinalExam;
-- Create database
CREATE DATABASE IF NOT EXISTS FinalExam;
USE FinalExam;

 -- Drop the table if it already exists
DROP TABLE IF EXISTS 	`user` ;
CREATE TABLE	`user` (
		`ID`				SMALLINT AUTO_INCREMENT PRIMARY KEY,
		Email				CHAR(30) UNIQUE NOT NULL,
        `Password`			NVARCHAR(50) NOT NULL,
        FirstName			NVARCHAR(50) NOT NULL,
        LastName			NVARCHAR(50) NOT NULL,
        Phone				VARCHAR(12) NOT NULL
        );
        
-- Drop the table if it already exists
DROP TABLE IF EXISTS Manager	;
CREATE TABLE	Manager (
		`ID`				SMALLINT AUTO_INCREMENT PRIMARY KEY,
		ExpInYear			TINYINT NOT NULL,
        IDUser				SMALLINT NOT NULL,
        FOREIGN KEY (IDUser) REFERENCES `user` (`ID`) ON DELETE CASCADE
        );	
        
-- Drop the table if it already exists
DROP TABLE IF EXISTS 	Employee;
CREATE TABLE	Employee (
		`ID`				SMALLINT AUTO_INCREMENT PRIMARY KEY,
		projectName			NVARCHAR(50) NOT NULL,
        proSkill			NVARCHAR(50) NOT NULL,
        IDUser				SMALLINT NOT NULL,
        FOREIGN KEY (IDUser) REFERENCES `user` (`ID`) ON DELETE CASCADE
        ); 