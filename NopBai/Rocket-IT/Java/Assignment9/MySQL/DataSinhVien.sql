-- =============================================
-- Create database
-- =============================================

-- Drop the database if it already exists
DROP DATABASE IF EXISTS SinhVien;
-- Create database
CREATE DATABASE IF NOT EXISTS SinhVien;
USE `USER`;

-- Drop the table if it already exists
DROP TABLE IF EXISTS 	ThucTapSinh;
CREATE TABLE	ThucTapSinh (
		Account				CHAR(50) PRIMARY KEY,
		Email				CHAR(30) UNIQUE NOT NULL,       
        FirstName			NVARCHAR(50) NOT NULL,
        LastName			NVARCHAR(50) NOT NULL,
        );
        