-- 升序
SELECT * FROM student 
ORDER BY math
INSERT INTO student VALUES(8, '韩信', 100, 100, 100);
SELECT * FROM student
SELECT * , (chinese + math + english) AS total_score FROM student
	ORDER BY total_score DESC;
	
SELECT * FROM student 
	WHERE `name` LIKE '韩%'
	ORDER BY math
	
SELECT `name`, (chinese + math + english) AS total_score FROM student
	WHERE `name` LIKE '韩%'
	ORDER BY total_score
	
SELECT * FROM student
	WHERE `name` LIKE '韩%'
	ORDER BY (chinese + math + english)
	
-- cout 返回行的总数
