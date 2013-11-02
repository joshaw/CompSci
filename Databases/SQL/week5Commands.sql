\dt
/*
--5.1A
SELECT lecturingTemp.cid, lecturingTemp.sid, staff.firstname, staff.lastname
FROM staff,
	(SELECT DISTINCT sid, year, cid
	FROM lecturing
	WHERE year = 2002 OR year =2004) AS lecturingTemp,
	(SELECT DISTINCT cid, semester
	FROM courses
	WHERE semester = 1 OR semester = 3) AS coursesTemp
WHERE coursesTemp.cid = lecturingTemp.cid AND
	lecturingTemp.sid = staff.sid AND
	staff.title <> 'Prof'
GROUP BY lecturingTemp.cid, lecturingTemp.sid, staff.lastname,
staff.firstname
ORDER BY lecturingTemp.cid, staff.lastname
;

--5.1B
SELECT lecturingTemp.cid
FROM staff,
	(SELECT DISTINCT sid, year, cid
	FROM lecturing
	WHERE year = 2002 OR year =2004) AS lecturingTemp,
	(SELECT DISTINCT cid, semester
	FROM courses
	WHERE semester = 3) AS coursesTemp
WHERE coursesTemp.cid = lecturingTemp.cid AND
	lecturingTemp.sid = staff.sid AND
	staff.title <> 'Prof'
GROUP BY lecturingTemp.cid
ORDER BY lecturingTemp.cid DESC
;

--5.1C
SELECT COUNT(*)
FROM (SELECT lecturingTemp.cid
	FROM staff,
		(SELECT DISTINCT sid, year, cid
		FROM lecturing
		WHERE year = 2002 OR year =2004) AS lecturingTemp,
		(SELECT DISTINCT cid, semester
		FROM courses
		WHERE semester = 3) AS coursesTemp
	WHERE coursesTemp.cid = lecturingTemp.cid AND
		lecturingTemp.sid = staff.sid AND
		staff.title <> 'Prof'
	GROUP BY lecturingTemp.cid
	ORDER BY lecturingTemp.cid DESC) AS tab
;
*/
--5.2A
SELECT DISTINCT bc
FROM allmarks03
WHERE mark IS NOT NULL
;
