--\c jaw097

DROP TABLE Object CASCADE;
DROP TABLE Planet CASCADE;
DROP TABLE Component CASCADE;
DROP TABLE Asteroid CASCADE;
DROP TABLE Disc_by CASCADE;
DROP TABLE Discoverer CASCADE;
DROP TABLE Star CASCADE;
DROP TABLE Elements CASCADE;
DROP TABLE Star_Elements CASCADE;

-- Super Type
CREATE TABLE Object (
	object_id SERIAL PRIMARY KEY,
	mass      INT    CHECK(mass > 0),
	avg_dist  INT    CHECK(avg_dist > 0)
);

-- Sub Type
CREATE TABLE Planet (
	object_id   SERIAL      REFERENCES Object,
	planet_name VARCHAR(30) UNIQUE PRIMARY KEY,
	year_length INT         CHECK(year_length > 0),
	class       CHAR(8)
);

-- Briding table for multivalued attribute
CREATE TABLE Component (
	planet_name  VARCHAR(30) REFERENCES Planet,
	component_id SERIAL,
	comp_name    VARCHAR(30),
	PRIMARY KEY (planet_name, component_id)
);

-- Sub Type
CREATE TABLE Asteroid (
	object_id    SERIAL REFERENCES Object,
	asteroid_id  SERIAL PRIMARY KEY,
	eccentricity DECIMAL CHECK(eccentricity > 0)
);

-- Table
CREATE TABLE Discoverer (
	firstname    VARCHAR(20),
	surname      VARCHAR(20) NOT NULL,
	title        VARCHAR(5)  NOT NULL,
	organisation VARCHAR(30),
	PRIMARY KEY (firstname, surname)
);

-- Briding table for M:N relationship
CREATE TABLE Disc_by (
	asteroid_id SERIAL      REFERENCES Asteroid,
	firstname   VARCHAR(20) REFERENCES Discoverer,
	surname     VARCHAR(20) REFERENCES Discoverer,
	date_disc   DATE,
	PRIMARY KEY (asteroid_id, firstname, surname)
);

-- Sub Type
CREATE TABLE Star (
	object_id  INT    REFERENCES Object,
	star_id    SERIAL PRIMARY KEY,
	luminosity INT    CHECK(luminosity > 0)
);

-- Table
CREATE TABLE Elements (
	atomic_number INT     CHECK(atomic_number > 0),
	atomic_mass   NUMERIC CHECK(atomic_mass > 0),
	PRIMARY KEY (atomic_number)
);

-- Briding table for M:N relationship
CREATE TABLE Star_Elements (
	star_id       SERIAL REFERENCES Star PRIMARY KEY,
	atomic_number INT    REFERENCES Elements
);

-- Bridging table for 1:1 symetric recursive relationship
CREATE TABLE orbit_member (
	orbit_num SERIAL,
	star_id   SERIAL REFERENCES Star,
	PRIMARY KEY (orbit_num, star_id)
);

-- Linking table for 1:1 symetric recursive relationship
CREATE TABLE orbit (
	orbit_num SERIAL  REFERENCES orbit_member PRIMARY KEY,
	radius    NUMERIC
);
