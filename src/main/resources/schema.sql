-- CREATE TABLE cities (
--                         city_id INT PRIMARY KEY AUTO_INCREMENT,
--                         name VARCHAR(50) UNIQUE NOT NULL,
--                         country VARCHAR(50)
-- );
--
-- CREATE TABLE heroes (
--                         hero_id INT PRIMARY KEY AUTO_INCREMENT,
--                         first_name VARCHAR(50),
--                         last_name VARCHAR(50),
--                         alias VARCHAR(50) UNIQUE,
--                         origin VARCHAR(30),
--                         year_created INT,
--                         universe VARCHAR(50),        -- e.g., Marvel, DC
--                         city_id INT,                 -- FK to cities
--                         CONSTRAINT fk_city FOREIGN KEY (city_id)
--                             REFERENCES cities(city_id)
--                             ON DELETE CASCADE
--                             ON UPDATE CASCADE
-- );
--
CREATE TABLE planets (
                         planet_id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(50),
                         type VARCHAR(50),
                         radius_km FLOAT,
                         mass_kg FLOAT,
                         orbital_period_days FLOAT
);

CREATE TABLE moons (
                       moon_id INT PRIMARY KEY AUTO_INCREMENT,
                       planet_id INT NOT NULL,
                       name VARCHAR(50),
                       diameter_km FLOAT,
                       orbital_period_days FLOAT,
                       CONSTRAINT fk_planet FOREIGN KEY (planet_id)
                           REFERENCES planets(planet_id)
                           ON DELETE CASCADE
                           ON UPDATE CASCADE
);

