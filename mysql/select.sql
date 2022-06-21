INSERT INTO `user` VALUES(1, 'tom', 123456, '2001-11-25');
UPDATE `user` 
	SET `password` = 456789 
	WHERE `name` = 'tom'
	
SELECT * FROM `user`
INSERT INTO `user` (id, `name`, `password`, `birthday`)
	VALUES(2, 'jack', 445644, '2001-2-3'); 	
	
UPDATE `user`
	SET `password` = 465132
	WHERE `name` = 'jack'
	
DELETE FROM `user`
	WHERE `name` = 'jack'
****创建新的表(student)********
CREATE TABLE student(
	id INT NOT NULL DEFAULT 1,
	NAME VARCHAR(20) NOT NULL DEFAULT '',
	chinese FLOAT NOT NULL DEFAULT 0.0,
	english FLOAT NOT NULL DEFAULT 0.0,
	math FLOAT NOT NULL DEFAULT 0.0
);

`student`


SELECT * FROM student

SELECT `name`, `english` FROM student
-- 要查询的记录里，每个字段都相同，才会去重
DISTINCT 

-- 查询每个学生的总分
SELECT `name`, (chinese + english + math) FROM student;

SELECT `name`, (chinese + english + math) AS total_score FROM student;

SELECT * FROM student WHERE math > 60 AND english >90

SELECT * FROM student WHERE english > chinese
-- 表示以韩开头的就可以
SELECT * FROM student WHERE (english + math + chinere) > 200 AND
	math < chinese AND 'name' LIKE '韩%'