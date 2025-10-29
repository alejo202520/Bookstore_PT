-- ============================================================
-- 📚 BOOKSTORE DATABASE INITIAL DATA
-- ============================================================

-- Géneros
INSERT INTO generes (name) VALUES
('Business & Money'),
('Comics'),
('Art & Photography');

-- Usuarios (contraseñas bcrypt actualizadas)
INSERT INTO users (full_name, username, password, state) VALUES
('Juan Perez', 'juan', '$2a$10$XxPhC1HUJQ.94zEVD0QggOtjJcR2CXgabbKaGTeeRBTkX1QhHYwfy', 'ACT'),
('María López', 'maria', '$2a$10$Y0QC3ngFNsSlw/vJiVwLTeY9FJJrAIshJusc7sLn4BdlhKXdSM.4S', 'ACT'),
('Carlos Ruiz', 'carlos', '$2a$10$qROXXpyLSJrrajZZsLqhqec/L9MKOiMO0H.76o06UR4tPtJks/R.y', 'ACT');

-- Libros
INSERT INTO books (name, summary, price, state, image, gen_id, usr_id) VALUES
('How to Win at Business', 'Resumen corto del libro 1', 29.99, 'ACT', 'https://placehold.co/200x300?text=Book1', 1, 1),
('El Arte del Emprendimiento', 'Resumen corto del libro 2', 19.50, 'ACT', 'https://placehold.co/200x300?text=Book2', 1, 2),
('Comic Hero Vol.1', 'Resumen de comic 1', 9.99, 'ACT', 'https://placehold.co/200x300?text=Comic1', 2, 3),
('Comic Adventures', 'Resumen de comic 2', 12.99, 'ACT', 'https://placehold.co/200x300?text=Comic2', 2, 1),
('Photography Basics', 'Resumen fotografía básica', 24.00, 'ACT', 'https://placehold.co/200x300?text=Photo1', 3, 2),
('Advanced Photography', 'Resumen de fotografía avanzada', 39.99, 'ACT', 'https://placehold.co/200x300?text=Photo2', 3, 3),
('Business Case Studies', 'Resumen de casos empresariales', 34.50, 'ACT', 'https://placehold.co/200x300?text=Book7', 1, 1),
('Children Comics', 'Resumen de cómics infantiles', 7.99, 'ACT', 'https://placehold.co/200x300?text=Comic3', 2, 2);
