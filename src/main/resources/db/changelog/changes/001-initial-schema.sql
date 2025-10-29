--liquibase formatted sql

--changeset alexavers:initial-schema
CREATE TABLE services (
    service_id serial PRIMARY KEY NOT NULL,
    description VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL,
    cost INT NOT NULL
);

CREATE TABLE vehicles (
    plate VARCHAR(10) PRIMARY KEY NOT NULL,
    brand VARCHAR(30) NOT NULL,
    model VARCHAR(40) NOT NULL
);

CREATE TABLE oils (
    oil_id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(25) NOT NULL,
    price INT NOT NULL
);

CREATE TABLE role (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(10) NOT NULL CHECK (role_name IN ('CUSTOMER', 'MECHANIC', 'ADMIN'))
);

CREATE TABLE country (
    country_id SERIAL PRIMARY KEY,
    country_name VARCHAR(50) NOT NULL
);

CREATE TABLE department (
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL
);

CREATE TABLE city (
    city_id SERIAL PRIMARY KEY,
    city_name VARCHAR(50) NOT NULL
);

CREATE TABLE address (
    address_id SERIAL PRIMARY KEY,
    country_id INT NOT NULL,
    department_id INT NOT NULL,
    city_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country(country_id),
    FOREIGN KEY (department_id) REFERENCES department(department_id),
    FOREIGN KEY (city_id) REFERENCES city(city_id),
    area TEXT NOT NULL,
    direction TEXT NOT NULL
);

CREATE TABLE users (
    dpi VARCHAR(15) PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    address_id INT NOT NULL,
    tel_number VARCHAR(10) NOT NULL,
    email TEXT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(role_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE appointments (
    appointment_id SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    service_id INT NOT NULL,
    plate VARCHAR(10) NOT NULL,
    oil BOOLEAN NOT NULL,
    users_dpi VARCHAR(15) not null,
    FOREIGN KEY (service_id) REFERENCES services(service_id),
    FOREIGN KEY (plate) REFERENCES vehicles(plate),
    FOREIGN KEY (users_dpi) REFERENCES users(dpi)
);