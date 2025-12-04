INSERT INTO cities (name, country)
VALUES
    ('New York City', 'USA'),      -- 1
    ('Gotham City', 'USA'),        -- 2
    ('Metropolis', 'USA'),         -- 3
    ('Asgard', 'Mythical'),        -- 4
    ('Atlantis', 'Mythical'),      -- 5
    ('Central City', 'USA'),       -- 6
    ('Coast City', 'USA'),         -- 7
    ('Westchester County', 'USA'), -- 8 - X-Men base (Xavier’s School)
    ('Themyscira', 'Mythical'),    -- 9 - Wonder Woman’s homeland
    ('Kamar-Taj', 'Nepal'),        -- 10 - Doctor Strange’s mystic base
    ('Unknown', 'Unknown');            -- 11 - fallback if needed

INSERT INTO heroes (first_name, last_name, alias, origin, year_created, universe, city_id)
VALUES
    ('Peter', 'Parker', 'Spider-Man', 'Human', 1962, 'Marvel', 1),
    ('Bruce', 'Wayne', 'Batman', 'Human', 1939, 'DC', 2),
    ('Clark', 'Kent', 'Superman', 'Kryptonian', 1938, 'DC', 3),
    ('Wade', 'Wilson', 'Deadpool', 'Human', 1991, 'Marvel', 1),
    ('Diana', 'Prince', 'Wonder Woman', 'Amazonian', 1941, 'DC', 9),
    ('Tony', 'Stark', 'Iron Man', 'Human', 1963, 'Marvel', 1),
    ('Natasha', 'Romanoff', 'Black Widow', 'Human', 1964, 'Marvel', 1),
    ('Stephen', 'Strange', 'Doctor Strange', 'Human', 1963, 'Marvel', 10),
    ('Hal', 'Jordan', 'Green Lantern', 'Human', 1959, 'DC', 7),
    ('Barry', 'Allen', 'The Flash', 'Human', 1956, 'DC', 6),
    ('Thor', NULL, 'Thor', 'Asgardian', 1962, 'Marvel', 4),
    ('Matt', 'Murdock', 'Daredevil', 'Human', 1964, 'Marvel', 1),
    ('Jessica', 'Jones', NULL, 'Human', 2001, 'Marvel', 1),
    ('Arthur', 'Curry', 'Aquaman', 'Atlantean/Human', 1941, 'DC', 5),
    ('Victor', 'Stone', 'Cyborg', 'Human', 1980, 'DC', 3),
    ('Scott', 'Summers', 'Cyclops', 'Mutant/Human', 1963, 'Marvel', 8),
    ('Logan', NULL, 'Wolverine', 'Mutant/Human', 1974, 'Marvel', 8),
    ('Jean', 'Grey', NULL, 'Mutant/Human', 1963, 'Marvel', 1);
