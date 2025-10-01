-- Archivo: V1__creacion_tablas_iniciales.sql


create table servicios(
servicio_id int primary key not null,
descripcion varchar(50) not null ,
tipo varchar(20) not null,
costo int not null
);

create table clientes(
cliente_id serial primary key not null,
nombre varchar(25) not null,
apellido varchar(25) not null,
telefono int not null,
direccion varchar(50) not null 
);

create table vehiculos(
placa varchar(10) primary key not null,
marca varchar(10) not null,
modelo varchar(10) not null
);

create table aceites(
aceite_id serial primary key not null,
nombre varchar(25) not null,
tipo varchar(25) not null,
precio int not null
);

create table mecanicos(
mecanico_id varchar(20) primary key not null,
nombre varchar(25) not null,
apellido varchar(25) not null,
telefono int not null
);

create table citas(
cita_id varchar(10)not null,
fecha date not null,
servicio_id varchar(10) not null,
cliente_id int not null,
placa varchar(10) not null,
mecanico_id varchar(10) not null,
aceite boolean not null,
primary key(cita_id, servicio_id),
foreign key (servicio_id) references servicios(servicio_id),
foreign key (cliente_id) references clientes(cliente_id),
foreign key (placa) references vehiculos(placa),
foreign key (mecanico_id) references mecanicos(mecanico_id)
);