--\c jaw097

DROP TABLE Object CASCADE;
DROP TABLE Planet CASCADE;
DROP TABLE Asteroid CASCADE;
DROP TABLE Disc_by CASCADE;
DROP TABLE Discoverer CASCADE;
DROP TABLE Star CASCADE;
DROP TABLE Elements CASCADE;
DROP TABLE Star_Elements CASCADE;

CREATE TABLE Object (object_id SERIAL PRIMARY KEY,
	                 mass      INT CHECK(mass > 0),
                     avg_dist  INT CHECK(avg_dist > 0)
                    );

CREATE TABLE Planet (object_id   SERIAL REFERENCES Object,
                     planet_id   SERIAL PRIMARY KEY,
                     year_length INT CHECK(year_length > 0),
                     class       CHAR(8)
                    );

CREATE TABLE Asteroid (object_id    SERIAL REFERENCES Object,
                       asteroid_id  SERIAL PRIMARY KEY,
                       eccentricity DECIMAL CHECK(eccentricity > 0)
                      );

CREATE TABLE Discoverer (firstname    VARCHAR(20),
                         surname      VARCHAR(20),
                         title        VARCHAR(5) NOT NULL,
                         organisation VARCHAR(30),
                         PRIMARY KEY (firstname, surname)
                         /* CHECK (title = "Mr" || title = "Mrs" || */
                         /* 	title = "Prof" || title = "Ms" ) */
                        );

CREATE TABLE Disc_by (asteroid_id SERIAL REFERENCES Asteroid,
                      firstname   VARCHAR(20) REFERENCES Discoverer,
                      surname     VARCHAR(20) REFERENCES Discoverer,
                      date_disc   DATE,
                      PRIMARY KEY (asteroid_id, firstname, surname)
                     );

CREATE TABLE Star (object_id  INT REFERENCES Object,
                   star_id    SERIAL PRIMARY KEY,
                   luminosity INT CHECK(luminosity > 0)
                  );

CREATE TABLE Elements (atomic_number INT CHECK(atomic_number > 0) PRIMARY KEY,
                       atomic_mass   NUMERIC CHECK(atomic_mass > 0)
                      );

CREATE TABLE Star_Elements (star_id INT REFERENCES Star PRIMARY KEY,
                            atomic_number INT REFERENCES Elements
                           );

\dt
