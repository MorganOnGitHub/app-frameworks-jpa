
CREATE TABLE planets (
                         planet_id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(50) UNIQUE,
                         type VARCHAR(50),
                         radius_km FLOAT,
                         mass_kg FLOAT,
                         orbital_period_days FLOAT
);

CREATE TABLE moons (
                       moon_id INT PRIMARY KEY AUTO_INCREMENT,
                       planet_id INT NOT NULL,
                       name VARCHAR(50) UNIQUE,
                       diameter_km FLOAT,
                       orbital_period_days FLOAT,
                       CONSTRAINT fk_planet FOREIGN KEY (planet_id)
                           REFERENCES planets(planet_id)
                           ON DELETE CASCADE
                           ON UPDATE CASCADE
);

CREATE TABLE my_users (
                      username VARCHAR(200) PRIMARY KEY NOT NULL,
                      password VARCHAR(200) NOT NULL,
                      enabled BOOLEAN NOT NULL,
                      unlocked BOOLEAN NOT NULL,
                      role VARCHAR(20)
);
