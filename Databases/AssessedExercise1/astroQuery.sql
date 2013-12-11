-- Get all the stars.
jaw097=> select * from star;
 object_id | star_id | luminosity
-----------+---------+------------
         1 |      21 |          4
         2 |      22 |          5
         3 |      23 |          6
         4 |      24 |          7
(4 rows)

-- Get all the planets.
jaw097=> SELECT * FROM planet
 object_id | planet_name | year_length |  class
-----------+-------------+-------------+----------
         5 | Zark        |           1 | rocky
         6 | Jupiter     |          12 | rocky
         7 | Io          |           4 | gasseous
(3 rows)

-- Get all the asteroids.
jaw097=> SELECT * FROM Asteroid;
 object_id | asteroid_id | eccentricity
-----------+-------------+--------------
         8 |          16 |          0.8
         9 |          17 |          0.1
        10 |          18 |          0.3
(3 rows)

-- Get all the components whether they are present in a planet or not.
jaw097=> SELECT * FROM component;
 planet_id | component id | comp name
-----------+--------------+-----------
         5 |           11 | iron
         5 |           12 | silicon
         5 |           13 | oxygen
         6 |           14 | iron
         6 |           15 | lithium
         6 |           16 | silicon
         6 |           17 | carbon
( 7 rows )

-- Get the details of all planets.
jaw097=> SELECT objectid, planetid, yearlength, class, mass
      -> FROM planet, object
      -> WHERE planet.object_id = object.objectid;
 object id | planet id | year length | class    | mass
-----------+-----------+-------------+----------+------
         5 |         1 |          1  | rocky    | 18
         6 |         2 |          12 | rocky    | 744
         7 |         3 |          4  | gasseous | 450

-- Get all the different components that are accounted for in at least
-- one planet.
jaw097=> SELECT DISTINCT (comp_name)
      -> FROM component, planet
      -> WHERE planet.planet_name = component.planet_name;
 comp name
-----------
 plutonium
 hydrogren
 iron
 silicon
 lithium
 oxygen
 carbon
( 7 rows )

-- Get the surname and organisation of the discoverers of any asteroid
-- with an eccentricity greater than 0.2.
jaw097=> SELECT discoverer.surname, discoverer.organisation
      -> FROM discoverer, disc_by, asteroid
      -> WHERE asteroid.asteroid_id = disc_by.asteroid_id AND
      ->       disc_by.firstname = asteroid.firstname AND
      ->       disc_by.surname = asteroid.surname AND
      ->       asteroid.eccentricity > 0.2;
 surname | organisation
---------+-------------
 Farrell | ESA
 Pearson | NASA
 King    | NASA
 Fleming | NASA
