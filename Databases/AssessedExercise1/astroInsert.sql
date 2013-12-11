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

INSERT INTO Star_Elements VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 7),
	(1, 8),
	(1, 16),
	(2, 1),
	(2, 2),
	(2, 3),
	(3, 1),
	(3, 2),
	(3, 3),
	(3, 5),
	(3, 11),
	(3, 6)
	;

INSERT INTO Elements VALUES
	(1, 1.001, 'Hydrogen'),
	(2, 4.003, 'Helium'),
	(3, 6.94, 'Lithium'),
	(4, 9.01, 'Beryllium'),
	(5, 10.81, 'Boron'),
	(6, 12.01, 'Carbon'),
	(7, 14.01, 'Nitrogen'),
	(8, 15.999, 'Oxygen'),
	(9, 18.998, 'Flourine'),
	(10, 20.18, 'Neon'),
	(11, 22.99, 'Sodium'),
	(12, 24.31, 'Magnesium'),
	(13, 26.98, 'Aluminium'),
	(14, 28.19, 'Silicon'),
	(15, 30.97, 'Phosphorus'),
	(16, 32.06, 'Sulphur'),
	(17, 35.45, 'Chlorine')
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

INSERT INTO disc_by VALUES
	(1, 'Michael', 'Farrell', 20/06/1998),
	(2, 'Katherine', 'Pearson', 29/09/1991),
	(2, 'David', 'King', 29/09/1991),
	(2, 'Amelie', 'Fleming', 29/09/1991),
	(3, 'Kate', 'Slater', 04/04/1999),
	(3, 'Freddie', 'Gould', 04/04/1999),
	(3, 'Sophie', 'Freeman', 04/04/1999)
	;

INSERT INTO discoverer VALUES
	('Mr', 'Michael', 'Farrell', 'ESA'),
	('Prof', 'Katherine', 'Pearson', 'NASA'),
	('Prof', 'David', 'King', 'NASA'),
	('Mrs', 'Amelie', 'Fleming', 'NASA'),
	('Mrs', 'Kate', 'Slater', 'NASA'),
	('Sir', 'Freddie', 'Gould',),
	('Prof', 'Sophie', 'Freeman', 'NASA')
	;
