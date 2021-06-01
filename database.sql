--
-- Banco de dados: `acme`
-- Nome do grupo: Conto de fadas
-- Membros: Igor Felipe Sales, Marlysson Xaview, Rodrigo Henrique
--

START TRANSACTION;
CREATE DATABASE IF NOT EXISTS acme;
USE acme;
CREATE TABLE IF NOT EXISTS `usuarios`(
	`ID` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password`VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `contatos`(
	`ID` INT PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(255) NOT NULL,
    `nome`VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `clients`(
	`ID` INT PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(255) NOT NULL
);


INSERT INTO `usuarios`(`username`, `password`)
VALUES('admin@admin.com', '12345');
INSERT INTO `usuarios`(`username`, `password`)
VALUES('igor@igor.com', '12345');
INSERT INTO `usuarios`(`username`, `password`)
VALUES('marlyson@marlyson.com', '12345');
INSERT INTO `usuarios`(`username`, `password`)
VALUES('rodrigo@rodrigo.com', '12345');
COMMIT;