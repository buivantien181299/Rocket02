USE quanlyfresher;

INSERT INTO Trainee 
		(TraineeID,	Full_Name, Birth_Date,Gender,ET_IQ,ET_Gmath,ET_English,Training_Class,Evaluation,VTI_Account)

VALUES 	(1,	'Viet anh',		'1999-10-21',	'Male',		'12',	'15',	'19',	'CNTT',	'good',		'abcd'),
		(2,	'Bui Tien',		'1999-12-18',	'Male',		'15',	'17',	'18',	'CNTT',	'good',		'bcef'),
        (3,	'ManhCuong',	'1997-8-21',	'Male',		'17',	'0',	'10',	'KTKT',	'not good',	'cdefg'),
        (4,	'Thu Thao',		'1999-7-15',	'Female',	'10',	'10',	'20','	CNTT',	'good',		'abcds'),
        (5,	'Ha Tien',		'1999-6-28',	'Male',		'18',	'17',	'15',	'CNTT',	'not good',	'aasd'),
        (6,	'Nguyen Thanh',	'1999-6-10',	'Male',		'15',	'17',	'12',	'CNTT',	'good',		'abvd'),
        (7,	'Cao Trang',	'1999-7-12',	'Female',	'12',	'15',	'19',	'KTKT',	'good',		'casfa'),
        (8,	'Tien Manh',	'2000-10-21',	'Male',		'12',	'15',	'19',	'KTKT',	'good',		'dasfs'),
        (9,	'Đinh Nguyet',	'1999-7-10',	'Female',	'10',	'20',	'19',	'CNTT',	'good',		'casf'),
        (10,'Trung Nhat',	'2000-10-21',	'Male',		'12',	'15',	'19',	'CNTT',	'not good',	'dasfd');
        
-- Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau.

-- bài này em order cho nó dễ thôi ạ :(
SELECT 
    full_name, birth_date, et_iq
FROM
    trainee
WHERE
    et_iq >= 15
ORDER BY MONTH(birth_date) DESC;

-- Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
	
SELECT 
    full_name,
    Gender,
    ET_IQ,
    ET_Gmath,
    ET_English,
    LENGTH(full_name),
    COUNT(LENGTH(full_name))
FROM
    trainee
WHERE
    LENGTH(full_name) = (SELECT 
            MAX(LENGTH(full_name))
        FROM
            trainee);
            
SELECT 
    full_name,
    Gender,
    ET_IQ,
    ET_Gmath,
    ET_English,
    LENGTH(full_name)
FROM
    trainee
GROUP BY
	full_name
HAVING
	 LENGTH(full_name) = (SELECT 
            MAX(LENGTH(full_name))
        FROM
            trainee);
/*
Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là
những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
 ET_IQ + ET_Gmath>=20
 ET_IQ>=8
 ET_Gmath>=8
 ET_English>=18
*/	

SELECT 
	TraineeID,
	FULL_NAME,
    GENDER,
    ET_IQ,
    ET_Gmath,
    ET_English,
    sum(ET_IQ + ET_Gmath) as Sum_ET
FROM
	trainee
WHERE 
    ET_IQ>=8 AND
    ET_Gmath>=8 AND
	ET_English>=18
GROUP BY
	FULL_NAME
having 
	sum(ET_IQ + ET_Gmath) >= 20;

-- xóa thực tập sinh có TraineeID = 3
COMMIT;
DELETE FROM
	trainee
WHERE 
	TraineeID = 3;

SELECT 
	TraineeID
FROM
	trainee;
    
ROLLBACK;

-- Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database.

UPDATE 
	trainee
SET
	Training_Class = '2'
WHERE 
	TraineeID = 5;