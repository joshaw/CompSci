DELETE FROM Object;
DELETE FROM component;
DELETE FROM Star;
DELETE FROM Planet;
DELETE FROM asteroid;

INSERT INTO Object VALUES
	(DEFAULT ,474, 2759),
	(DEFAULT ,204, 3679),
	(DEFAULT ,216, 1576),
	(DEFAULT ,601, 3916),
	(DEFAULT ,18, 4502),
	(DEFAULT ,744, 2993),
	(DEFAULT ,450, 10704),
	(DEFAULT ,162, 5063),
	(DEFAULT ,515, 2107),
	(DEFAULT ,315, 4107)
	;

INSERT INTO star VALUES
	(1, DEFAULT, 4),
	(2, DEFAULT, 5),
	(3, DEFAULT, 6),
	(4, DEFAULT, 7)
	;

INSERT INTO planet VALUES
	(5, 'Zark', 1.3, 'rocky'),
	(6, 'Jupiter', 12, 'rocky'),
	(7, 'Io', 4.3, 'gasseous')
	;

INSERT INTO component VALUES
	('Zark', DEFAULT, 'plutonium'),
	('Zark', DEFAULT, 'carbon'),
	('Zark', DEFAULT, 'hydrogren'),
	('Jupiter', DEFAULT, 'iron'),
	('Jupiter', DEFAULT, 'silicon'),
	('Jupiter', DEFAULT, 'oxygen'),
	('Io', DEFAULT, 'iron'),
	('Io', DEFAULT, 'lithium'),
	('Io', DEFAULT, 'silicon'),
	('Io', DEFAULT, 'carbon')
	;

INSERT INTO asteroid VALUES
	(8, DEFAULT, 0.8),
	(9, DEFAULT, 0.1),
	(10, DEFAULT, 0.3)
	;
