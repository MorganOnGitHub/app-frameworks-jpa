CREATE TABLE cities (
                        city_id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(50) UNIQUE NOT NULL,
                        country VARCHAR(50)
);

CREATE TABLE heroes (
                        hero_id INT PRIMARY KEY AUTO_INCREMENT,
                        first_name VARCHAR(50),
                        last_name VARCHAR(50),
                        alias VARCHAR(50) UNIQUE,
                        origin VARCHAR(30),
                        year_created INT,
                        universe VARCHAR(50),        -- e.g., Marvel, DC
                        city_id INT,                 -- FK to cities
                        CONSTRAINT fk_city FOREIGN KEY (city_id)
                            REFERENCES cities(city_id)
                            ON DELETE CASCADE
                            ON UPDATE CASCADE
);



