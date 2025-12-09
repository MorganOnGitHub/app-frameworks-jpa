
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

