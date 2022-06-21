CREATE TABLE `emp`(
	id INT,
	`name` VARCHAR(32),
	sex CHAR(1),
	birthday DATE,
	entry_date DATETIME,
	job VARCHAR(32),
	salary DOUBLE,
	`resume` TEXT) 
	
ALTER TABLE emp ADD address VARCHAR(60) NOT NULL DEFAULT '' AFTER NAME

ALTER TABLE emp MODIFY sex CHAR(2) NOT NULL DEFAULT ''
RENAME TABLE emp TO employee
CREATE TABLE `goods`(
	id INT,
	`name` VARCHAR(50),
	price INT);
INSERT INTO goods VALUES(
	1, '华为手机', 2000);
	
INSERT INTO goods VALUES(
	2, '苹果手机', 3000);
-- 如果是给表里的所有字段添加数据可以省略前面的字段名称，当没有给某个字段
-- 赋值，就默认赋值	
INSERT INTO goods VALUES(
	3, 8848, 50000), (4, '锤子手机', 80000);
INSERT INTO goods (id, `name`, price) 
	VALUES(5,'菠萝手机', 900000);
