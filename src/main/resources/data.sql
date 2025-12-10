
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

INSERT INTO my_users (username, password, enabled, unlocked, role) VALUES
('admin','$2a$12$TyZyF8qlubhLg13tQjUum.burhvBMzyX.J1GUcUHlOqn6MOWSvxXS',true, true, 'ROLE_ADMIN'), -- password1
('john', '$2a$12$TyZyF8qlubhLg13tQjUum.burhvBMzyX.J1GUcUHlOqn6MOWSvxXS',true, true, 'ROLE_STAFF'),
('amy', '$2a$12$TyZyF8qlubhLg13tQjUum.burhvBMzyX.J1GUcUHlOqn6MOWSvxXS',true, true, 'ROLE_STUDENT'),
('maria', '$2a$12$TyZyF8qlubhLg13tQjUum.burhvBMzyX.J1GUcUHlOqn6MOWSvxXS', true, true, 'ROLE_STAFF'),
('lee', '$2a$12$TyZyF8qlubhLg13tQjUum.burhvBMzyX.J1GUcUHlOqn6MOWSvxXS', false, false, 'ROLE_STUDENT');