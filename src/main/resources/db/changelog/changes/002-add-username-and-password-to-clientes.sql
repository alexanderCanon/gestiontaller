-- Archivo: 002-add-username-and-password-to-clientes.sql

ALTER TABLE clientes
ADD COLUMN username VARCHAR(50) UNIQUE,
ADD COLUMN password VARCHAR(100);
