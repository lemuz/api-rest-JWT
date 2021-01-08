CREATE DATABASE backoffice;

USE backoffice;

CREATE TABLE usuario (
	id_usuario int NOT NULL AUTO_INCREMENT,
	nickname varchar(50) NOT NULL,
	contrasena_usuario varchar(500) not null,
	edad_usuario tinyint NOT NULL,
	nombre_usuario varchar(50) NOT NULL,
	apellido_usuario varchar(100) NOT NULL,
	correo_usuario varchar(100) NOT NULL,
	telefono_usuario varchar(20) NOT NULL,
	direccion_usuario varchar(300) NOT NULL,
	pais_usuario varchar(3) NOT NULL,
	provincia_usuario varchar(3) NOT NULL,
	ciudad_usuario varchar(3) NOT NULL,
	identificacion_usuario varchar(3) NOT NULL,
	PRIMARY KEY (id_usuario)
);

CREATE TABLE rol(
	id_rol int NOT NULL AUTO_INCREMENT,
	nombre_rol varchar(5) NOT NULL,
	PRIMARY KEY(id_rol)
);

CREATE TABLE usuario_rol(
	id_usuario_rol int NOT NULL AUTO_INCREMENT,
	id_usuario int NOT NULL,
	id_rol int NOT NULL,
	PRIMARY KEY(id_usuario_rol),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	FOREIGN KEY(id_rol) REFERENCES rol(id_rol)
);