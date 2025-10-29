-- ============================================================
-- BOOKSTORE DATABASE SCHEMA
-- Autor: Alexander Acosta
-- Base de datos: PostgreSQL
-- Fecha: Octubre 2025
-- ============================================================

-- Eliminar tablas existentes si existen
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS generes CASCADE;

-- Tabla: generes
DROP TABLE IF EXISTS generes CASCADE;

CREATE TABLE generes (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

-- Tabla: users
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    state VARCHAR(50) NOT NULL
);


-- Tabla: books
DROP TABLE IF EXISTS books CASCADE;
CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    summary VARCHAR(500),
    price NUMERIC(8,2),
    state VARCHAR(3),
    image VARCHAR(500),
    gen_id BIGINT,
    usr_id BIGINT,
    CONSTRAINT fk_gen FOREIGN KEY (gen_id) REFERENCES generes(id),
    CONSTRAINT fk_usr FOREIGN KEY (usr_id) REFERENCES users(id)
);
