/*
--3.2.2
SELECT firstname,lastname,office,phone
FROM staff
WHERE phone IS NULL AND office IS NOT NULL
;

--3.2.3
SELECT *
FROM lecturing
WHERE year = 2000 OR year >= 2002
ORDER BY cid
;

--3.2.4a

SELECT firstname,lastname,office
FROM staff
WHERE office IN (
	SELECT office
	FROM staff
	WHERE office IS NOT  NULL
	GROUP BY office
	HAVING COUNT(*) > 1
)
ORDER BY office
;

--??????????????????????????
--3.2.4b
SELECT office,firstname
FROM staff
WHERE office IS NOT NULL
EXCEPT ALL
SELECT office,lastname
FROM staff
ORDER BY office
;
--??????????????????????????

--3.2.5
SELECT cid,AVG(numbers) AS "Average Numbers" ,MAX(year) AS "Last Year Given"
FROM lecturing
WHERE year > 2000
GROUP BY cid
ORDER BY cid
;

--3.2.6
SELECT cid, AVG(numbers) AS "Average Numbers", MAX(year) AS "Last Year Given",
	COUNT(sid) AS "No. Lecturers"
FROM lecturing
WHERE year > 2000
GROUP BY cid
HAVING COUNT(sid) > 1
ORDER BY cid
;

--3.2.7
SELECT bc, MIN(mark)
FROM allmarks04
WHERE mark >= 40
GROUP BY bc
HAVING MIN(mark) > 5 + (SELECT AVG(mark) FROM allmarks04)
;
*/
