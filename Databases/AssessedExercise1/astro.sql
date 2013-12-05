\c jaw097

DROP TABLE Object CASCADE;
DROP TABLE Planet CASCADE;
DROP TABLE Asteroid CASCADE;
DROP TABLE Disc_by CASCADE;
DROP TABLE Discoverer CASCADE;
DROP TABLE Star CASCADE;
DROP TABLE Elements CASCADE;
DROP TABLE Star_Elements CASCADE;

CREATE TABLE Object (object_id SERIAL PRIMARY KEY,
	                 mass      INT,
                     avg_dist  INT
                    );

CREATE TABLE Planet (planet_id   SERIAL PRIMARY KEY,
                     year_length INT,
                     class       CHAR(8)
                    );

CREATE TABLE Asteroid (asteroid_id  SERIAL PRIMARY KEY,
                       eccentricity INT
                      );

CREATE TABLE Discoverer (firstname    VARCHAR(20),
                         surname      VARCHAR(20),
                         title        VARCHAR(5) NOT NULL,
                         organisation VARCHAR(30),
                         PRIMARY KEY (firstname, surname)
                        );

CREATE TABLE Disc_by (asteroid_id INT REFERENCES Asteroid,
                      firstname   VARCHAR(20) REFERENCES Discoverer,
                      surname     VARCHAR(20) REFERENCES Discoverer,
                      date_disc   DATE
                     );

CREATE TABLE Star (star_id    SERIAL PRIMARY KEY,
                   luminosity INT
                  );

CREATE TABLE Elements (atomic_number INT PRIMARY KEY,
                       atomic_mass   NUMERIC
                      );

CREATE TABLE Star_Elements (star_id INT REFERENCES Star PRIMARY KEY,
                            atomic_number INT REFERENCES Elements
                           );

\dt
