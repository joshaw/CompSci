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

jaw097=> SELECT objectid, planetid, yearlength, class, mass
      -> FROM planet, object
      -> WHERE planet.object_id = object.objectid;
 object id | planet id | year length | class    | mass
-----------+-----------+-------------+----------+------
         5 |         1 |          1  | rocky    | 18
         6 |         2 |          12 | rocky    | 744
         7 |         3 |          4  | gasseous | 450

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
