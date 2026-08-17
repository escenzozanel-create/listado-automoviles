-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.21.0.7344
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para automoviles
CREATE DATABASE IF NOT EXISTS `automoviles` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `automoviles`;

-- Volcando estructura para tabla automoviles.automovil
CREATE TABLE IF NOT EXISTS `automovil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anio` int(11) DEFAULT NULL,
  `clase` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla automoviles.automovil: ~10 rows (aproximadamente)
INSERT INTO `automovil` (`id`, `anio`, `clase`, `color`, `marca`, `modelo`, `precio`) VALUES
	(1, 2022, 'Sedan', 'Blanco', 'Toyota', 'Corolla', 22000),
	(2, 2020, 'Hatchback', 'Rojo', 'Ford', 'Fiesta', 15000),
	(3, 2021, 'Sedan', 'Gris', 'Chevrolet', 'Cruze', 19000),
	(4, 2019, 'Hatchback', 'Negro', 'Volkswagen', 'Gol', 12000),
	(5, 2023, 'SUV', 'Blanco', 'Renault', 'Duster', 26000),
	(6, 2022, 'Sedan', 'Azul', 'Fiat', 'Cronos', 17000),
	(7, 2021, 'Hatchback', 'Gris', 'Peugeot', '208', 18000),
	(8, 2020, 'Sedan', 'Negro', 'Honda', 'Civic', 24000),
	(9, 2023, 'SUV', 'Verde', 'Jeep', 'Renegade', 31000),
	(10, 2022, 'SUV', 'Rojo', 'Nissan', 'Kicks', 27000);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
