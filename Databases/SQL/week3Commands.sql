--3.1.1
SELECT COUNT(*) AS "No. Records in LECTURING"
FROM lecturing
;
SELECT COUNT(*) AS "No. Records in COURSES"
FROM courses
;
SELECT COUNT(*) AS "No. Records in STAFF"
FROM staff
;

--3.1.2
SELECT sid, firstname, lastname
FROM staff
WHERE office > 199
;

--3.1.3
SELECT office, phone, lastname
FROM staff
WHERE firstname = 'Mark'
;

--3.1.4
SELECT firstname, lastname, phone
FROM staff
WHERE office > 100
ORDER BY firstname DESC
;

--3.1.5
SELECT sid
FROM staff
WHERE title <> 'Prof'
ORDER BY sid
;

--3.2.1
SELECT cid
FROM courses
WHERE level > 1 AND level < 4 AND semester = 1
;

--3.2.2
SELECT firstname, lastname, office, phone
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

--3.2.4b
SELECT office
FROM staff
WHERE office IS NOT NULL
EXCEPT ALL
SELECT DISTINCT office
FROM staff
ORDER BY office
;

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
