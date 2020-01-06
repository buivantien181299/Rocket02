DROP DATABASE IF EXISTS KhachHang;
CREATE DATABASE IF NOT EXISTS KhachHang;

USE KhachHang;

DROP TABLE IF EXISTS Customer;
CREATE TABLE IF NOT EXISTS Customer
(
	CustomerID			TINYINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Name				VARCHAR(50) NOT NULL,
    Phone				CHAR(12) NOT NULL,
    Email				CHAR(25) NOT NULL,
    Address				VARCHAR(50) NOT NULL,
    Note				VARCHAR(50) NOT NULL
);

INSERT INTO	Customer 
			(Name, Phone, Email, Address, Note)
VALUES
			('Bui Van',		'0963067040',	'buivantien@gmail.com', 		'Thai Binh',	'Binh Thuong'),
            ('Nguyen Thi',	'0963067041',	'Nguyenthi1202@gmail.com', 		'Hung Yen',		'Hoi Lun'),
            ('Cao Thi',		'0963067042',	'CaoThi0201@gmail.com', 		'Nghe An',		'Kho Tinh'),
            ('Ngo Van',		'0963067043',	'ngoavan@gmail.com', 			'Thai Binh',	'Binh thuong'),
            ('Nguyen Thanh','0963067044',	'nguyenthanh@gmail.com', 		'Nghe An',		'Binh thuong'),
            ('Dinh Thi',	'0963067045',	'dinhthi@gmail.com', 			'Thai Binh',	'Hoi Lun'),
            ('Ha Thanh',	'0963067046',	'hathanh@gmail.com', 			'Hung Yen',		'Binh thuong'),
            ('Le Thi',		'0963067047',	'lethi@gmail.com', 				'Thai Binh',	'Kho Tinh'),
            ('Nguyen Long',	'0963067048',	'nguyenlong@gmail.com', 		'Hung Yen',	'Kho Tinh'),
            ('Vo Thi',		'0963067049',	'vothi@gmail.com', 				'Thai Binh',	'Binh thuong');


DROP TABLE IF EXISTS Car;
CREATE TABLE IF NOT EXISTS Car
(
	CarID				CHAR(10) PRIMARY KEY NOT NULL,
    Maker				VARCHAR(20) NOT NULL,
    Model				VARCHAR(50) NOT NULL,
    Year				CHAR(4) NOT NULL,
    Color				CHAR(12) NOT NULL,
    Note				VARCHAR(50) NOT NULL
);

INSERT INTO	Car
			(CarID,	Maker, Model, Year, Color, Note)
VALUES
			('CAR001',	'HONDA', 	'Xe mui tran',	'2019',		'den',		'dat vcl'),
            ('CAR002',	'TOYOTAA', 	'Xe bon cho',	'2017',		'xanh',		'gia binh thuong'),
            ('CAR003',	'NISSANN', 	'Xe bay cho',	'2019',		'trang',	'gia binh thuong'),
            ('CAR004',	'NISSANB', 	'Xe mui tran',	'2018',		'xanh',		'dat vcl'),
            ('CAR005',	'NISSANC', 	'Xe du lich',	'2015',		'den',		'gia binh thuong'),
            ('CAR006',	'HONDAX', 	'Xe bon cho',	'2018',		'trang',	'gia binh thuong'),
            ('CAR007',	'TOYOTAZ', 	'Xe mui tran',	'2019',		'den',		'dat vcl'),
            ('CAR008',	'TOYOTAƯ', 	'Xe du lich',	'2019',		'xam',		'gia binh thuong'),
            ('CAR009',	'HONDAE', 	'Xe du lich',	'2016',		'trang',	'gia binh thuong'),
            ('CAR010',	'TOYOTAR', 	'Xe bay cho',	'2019',		'den',		'dat vcl');
            

DROP TABLE IF EXISTS Order_Car;
CREATE TABLE IF NOT EXISTS Order_Car
(
	OrderID				TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	CustomerID          TINYINT NOT NULL,
	CarID				CHAR(10) NOT NULL,
    Amount				TINYINT	DEFAULT 1,
    SalePrice			DECIMAL(9),
    OrderDate 			DATE NOT NULL,
    DeliveryDate		DATE NOT NULL,
    DeliveryAddress     VARCHAR(50) NOT NULL,
    Staus				ENUM('0','1','2') DEFAULT '0',
    Note				VARCHAR(50) NOT NULL,
    FOREIGN KEY (CustomerID) 	REFERENCES Customer(CustomerID),
    FOREIGN KEY (CarID) 		REFERENCES Car(CarID)
);

INSERT INTO Order_Car 
		(CustomerID, CarID, Amount, SalePrice,OrderDate, DeliveryDate, DeliveryAddress, Staus, Note)
VALUES
		(1,'CAR001', 	5, 500000000, '2020-01-01' ,'2020-01-02', 'Thai Binh',	'1', 'Binh thuong'),
        (3,'CAR002', 	2, 700000000, '2019-11-10','2019-11-12', 'Hung Yen',	'0', 'Binh thuong'),
        (4,'CAR002', 	2, 700000000, '2019-10-10','2019-10-12', 'Nghe An',		'2', 'Da Huy'		),
        (5,'CAR005', 	1, 600000000, '2020-01-02','2020-01-03', 'Thai Binh',	'1', 'Binh thuong'),
        (7,'CAR009', 	3, 200000000, '2019-09-10','2019-12-12', 'Thai Binh',	'0', 'Binh thuong'),
        (9,'CAR006', 	3, 800000000, '2019-08-10','2019-11-12', 'Thai Binh',	'0', 'Binh thuong'),
        (2,'CAR001', 	2, 300000000, '2019-07-10','2019-10-12', 'Nghe An',		'2', 'Da huy'		),
        (1,'CAR009',	5, 400000000, '2019-06-10','2019-10-12', 'Hung Yen',	'1', 'Binh thuong'),
        (4,'CAR004', 	3, 200000000, '2019-05-10','2019-11-12', 'Thai Binh',	'0', 'Binh thuong'),
        (7,'CAR003', 	5, 100000000, '2019-04-10','2019-12-12', 'Nghe An',		'1', 'Binh thuong');
        
-- Cau 1: Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.

SELECT c.name, SUM(oc.Amount),oc.CustomerID
FROM Order_Car oc
	JOIN
	Customer c ON c.CustomerID = oc.CustomerID
WHERE oc.Staus = '1'
GROUP BY oc.CustomerID
ORDER BY SUM(oc.Amount);

-- Cau 2: Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.

DROP FUNCTION IF EXISTS f_name_sx;

DELIMITER $$
CREATE FUNCTION f_name_sx()  RETURNS VARCHAR(20)
	BEGIN
		DECLARE v_name_hang VARCHAR(20);
		SELECT  c.Maker INTO v_name_hang
        FROM Car c
				JOIN
			Order_Car oc ON oc.CarID = c.CarID
        WHERE  YEAR(oc.OrderDate) = YEAR(now())       
		GROUP BY c.Maker 
        HAVING SUM(oc.Amount) = (	SELECT MAX(sum_1) 
						FROM (SELECT SUM(Amount) AS sum_1
								FROM Order_Car
								WHERE Staus = '1'
                                GROUP BY CarID) TMP);
		RETURN v_name_hang;
	END $$
DELIMITER ;



-- Câu 3:  Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.

DROP PROCEDURE IF EXISTS p_delete_xe;

DELIMITER $$
CREATE PROCEDURE p_delete_xe()
		BEGIN
			DELETE FROM Order_Car
            WHERE  YEAR(now()) > YEAR(DeliveryDate) AND Order_Car.Staus = '2';
	
            SELECT ROW_COUNT();
        END $$
DELIMITER ;


/* Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
và tên hãng sản xuất */

DROP PROCEDURE IF EXISTS p_infor_cus;
DELIMITER $$
CREATE PROCEDURE p_infor_cus (in p_CustomerID TINYINT)
		BEGIN
			SELECT cus.Name, oc.OrderID, SUM(oc.Amount), c.Maker
            FROM Order_Car oc
				JOIN 
                Customer cus ON cus.CustomerID = oc.CustomerID
                JOIN
                Car c ON c.CarID = oc.CarID
			WHERE cus.CustomerID = p_CustomerID;
        END $$
DELIMITER ;

/*
Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
vào database (DeliveryDate < OrderDate + 15).
*/

DROP TRIGGER IF EXISTS t_check_infor;

DELIMITER $$
CREATE TRIGGER t_check_infor
BEFORE  INSERT ON  Order_Car
FOR EACH ROW
	BEGIN
		IF (NEW.DeliveryDate > date_add(NEW.OrderDate,INTERVAL 15 DAY) ) THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'tien dep zai';
		END IF; 
    END $$
DELIMITER ;

INSERT INTO Order_Car 
			(CustomerID, CarID, Amount, SalePrice,OrderDate, DeliveryDate, DeliveryAddress, Staus, Note)
	VALUES (2, 'CAR002', 	5 ,  50000000,  '2019-01-01' ,  '2019-01-20',   'Thai Binh',	 '1',   'Binh thuong');