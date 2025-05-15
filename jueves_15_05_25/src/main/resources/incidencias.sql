CREATE DATABASE IF NOT EXISTS incidencias;
USE incidencias;

CREATE TABLE tecnicos (
    id_tecnico INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE incidencias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    CHECK (estado IN ('Abierta', 'En progreso', 'Cerrada')),
    id_tecnico INT NOT NULL,
    FOREIGN KEY (id_tecnico) REFERENCES tecnicos(id_tecnico)
);