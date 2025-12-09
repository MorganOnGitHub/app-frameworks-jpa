-- INSERT INTO cities (name, country)
-- VALUES
--     ('New York City', 'USA'),      -- 1
--     ('Gotham City', 'USA'),        -- 2
--     ('Metropolis', 'USA'),         -- 3
--     ('Asgard', 'Mythical'),        -- 4
--     ('Atlantis', 'Mythical'),      -- 5
--     ('Central City', 'USA'),       -- 6
--     ('Coast City', 'USA'),         -- 7
--     ('Westchester County', 'USA'), -- 8 - X-Men base (Xavier’s School)
--     ('Themyscira', 'Mythical'),    -- 9 - Wonder Woman’s homeland
--     ('Kamar-Taj', 'Nepal'),        -- 10 - Doctor Strange’s mystic base
--     ('Unknown', 'Unknown');            -- 11 - fallback if needed
--
-- INSERT INTO heroes (first_name, last_name, alias, origin, year_created, universe, city_id)
-- VALUES
--     ('Peter', 'Parker', 'Spider-Man', 'Human', 1962, 'Marvel', 1),
--     ('Bruce', 'Wayne', 'Batman', 'Human', 1939, 'DC', 2),
--     ('Clark', 'Kent', 'Superman', 'Kryptonian', 1938, 'DC', 3),
--     ('Wade', 'Wilson', 'Deadpool', 'Human', 1991, 'Marvel', 1),
--     ('Diana', 'Prince', 'Wonder Woman', 'Amazonian', 1941, 'DC', 9),
--     ('Tony', 'Stark', 'Iron Man', 'Human', 1963, 'Marvel', 1),
--     ('Natasha', 'Romanoff', 'Black Widow', 'Human', 1964, 'Marvel', 1),
--     ('Stephen', 'Strange', 'Doctor Strange', 'Human', 1963, 'Marvel', 10),
--     ('Hal', 'Jordan', 'Green Lantern', 'Human', 1959, 'DC', 7),
--     ('Barry', 'Allen', 'The Flash', 'Human', 1956, 'DC', 6),
--     ('Thor', NULL, 'Thor', 'Asgardian', 1962, 'Marvel', 4),
--     ('Matt', 'Murdock', 'Daredevil', 'Human', 1964, 'Marvel', 1),
--     ('Jessica', 'Jones', NULL, 'Human', 2001, 'Marvel', 1),
--     ('Arthur', 'Curry', 'Aquaman', 'Atlantean/Human', 1941, 'DC', 5),
--     ('Victor', 'Stone', 'Cyborg', 'Human', 1980, 'DC', 3),
--     ('Scott', 'Summers', 'Cyclops', 'Mutant/Human', 1963, 'Marvel', 8),
--     ('Logan', NULL, 'Wolverine', 'Mutant/Human', 1974, 'Marvel', 8),
--     ('Jean', 'Grey', NULL, 'Mutant/Human', 1963, 'Marvel', 1);
-- sample planets
INSERT INTO planets (name, type, radius_km, mass_kg, orbital_period_days) VALUES
('Mercury', 'terrestrial', 2439.7, 3.3011e23, 87.97),
('Venus', 'terrestrial', 6051.8, 4.8675e24, 224.70),
('Earth', 'terrestrial', 6371.0, 5.972e24, 365.26),
('Mars', 'terrestrial', 3389.5, 6.4171e23, 686.98),
('Jupiter', 'gas giant', 69911.0, 1.8982e27, 4332.59),
('Saturn', 'gas giant', 58232.0, 5.6834e26, 10759.22),
('Uranus', 'ice giant', 25362.0, 8.6810e25, 30688.5),
('Neptune', 'ice giant', 24622.0, 1.02413e26, 60182.0);

-- sample moons
INSERT INTO moons (name, diameter_km, orbital_period_days, planet_id) VALUES
-- Earth's moon
('Moon', 3474.8, 27.32, 3),

-- Mars's moons
('Phobos', 22.2, 0.319, 4),
('Deimos', 12.6, 1.263, 4),

-- Jupiter's major moons
('Io', 3643.2, 1.769, 5),
('Europa', 3121.6, 3.551, 5),
('Ganymede', 5268.2, 7.155, 5),
('Callisto', 4820.6, 16.689, 5),

-- Saturn's major moons
('Titan', 5149.5, 15.945, 6),
('Rhea', 1527.0, 4.518, 6),
('Iapetus', 1469.0, 79.330, 6),
('Dione', 1123.0, 2.737, 6),
('Tethys', 1062.0, 1.888, 6),
('Enceladus', 504.2, 1.370, 6),
('Mimas', 396.4, 0.942, 6),

-- Uranus's major moons
('Titania', 1577.8, 8.706, 7),
('Oberon', 1522.8, 13.463, 7),
('Umbriel', 1169.4, 4.144, 7),
('Ariel', 1157.8, 2.520, 7),
('Miranda', 471.6, 1.413, 7),

-- Neptune's major moons
('Triton', 2706.8, 5.877, 8),
('Proteus', 420.0, 1.122, 8);
