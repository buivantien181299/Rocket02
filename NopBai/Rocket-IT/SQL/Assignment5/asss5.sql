USE adventureworks;

-- Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'.

SELECT 
    p.`NAME`
FROM
    ProductSubcategory ps
        JOIN
    Product p ON p.ProductSubcategoryID = ps.ProductSubcategoryID
WHERE
    ps.`name` = 'Saddles';
    
SELECT 
    name
FROM
    product 
WHERE
    ProductSubcategoryID IN (SELECT 
								ps.ProductSubcategoryID
							FROM
								ProductSubcategory ps
							WHERE
								 ps.`name` = 'Saddles');
    
/* Thay đổi câu Query 1 để lấy được kết quả sau
	Name
----------------------------
Water Bottle - 30 oz.
Mountain Bottle Cage
Road Bottle Cage
LL Bottom Bracket
ML Bottom Bracket
HL Bottom Bracket

Bottles and Cages
*/
SELECT p.NAME
FROM ProductSubcategory ps
	JOIN
    Product p ON p.ProductSubcategoryID = ps.ProductSubcategoryID
WHERE 
	 ps.name LIKE "%bo%" ;

SELECT 
    p.name
FROM
    product p
WHERE
    p.ProductSubcategoryID IN (SELECT 
           ps.ProductSubcategoryID
        FROM
            ProductSubcategory ps
        WHERE
            ps.name LIKE '%bo%');

SELECT * FROM  ProductSubcategory;
SELECT * FROM  product Where name = 'Mountain Bottle Cage';

-- Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring Bikes (nghĩa là ProductSubcategoryID = 3)

SELECT 
    Listprice AS gia_it_nhat, name
FROM
    product
WHERE
    ProductSubcategoryID IN (SELECT 
            ProductSubcategoryID
        FROM
            ProductSubcategory
        WHERE
            NAME = 'Touring Bikes')
        AND ListPrice = (SELECT 
            MIN(ListPrice)
        FROM
            ProductSubcategory ps
                JOIN
            Product p ON p.ProductSubcategoryID = ps.ProductSubcategoryID
        WHERE
            ps.`name` = 'Touring Bikes'
                );
Select `name`
from ProductSubcategory
where ProductSubcategoryID = "3";

-- Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database. 
SELECT 
    cr.name AS country, sp.name AS province
FROM
    stateprovince sp
        JOIN
    countryregion cr ON cr.CountryRegionCode = sp.CountryRegionCode;
    
-- Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada.

SELECT cr.name AS country, sp.name AS province
FROM 
stateprovince sp
JOIN
countryregion cr ON cr.CountryRegionCode = sp.CountryRegionCode
WHERE cr.name = 'Canada' OR cr.name = 'Germany'
ORDER BY country;

-- SalesOrderID, OrderDate and SalesPersonID. Từ bảng SalesPerson, chúng ta lấy cột BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay).

CREATE OR REPLACE VIEW v_Khach_hang_sales AS

SELECT 
    so.salesorderID,
    so.orderdate,
    so.SalesPersonID,
    so.SalesPersonID AS BusinessEntityID,
    sp.bonus,
    sp.SalesYTD,
    so.PurchaseOrderNumber,
    so.OnlineOrderFlag
FROM
    salesorderheader so
       LEFT JOIN
    salesperson sp ON so.SalesPersonID = sp.SalesPersonID;
    
-- Sử dụng câu query, thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID.

SELECT 
    so.salesorderID,
    so.orderdate,
    sp.bonus,
    sp.SalesYTD,
    e.title
FROM
    salesorderheader so
        JOIN
    salesperson sp ON so.SalesPersonID = sp.SalesPersonID
		JOIN
	employee e ON e.EmployeeID = so.SalesPersonID;
