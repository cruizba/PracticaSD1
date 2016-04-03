-- MySQL Script generated by MySQL Workbench
-- 03/22/16 19:03:21
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd-practica1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bd-practica1` ;

-- -----------------------------------------------------
-- Schema bd-practica1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-practica1` DEFAULT CHARACTER SET utf8 ;
USE `bd-practica1` ;

-- -----------------------------------------------------
-- Table `bd-practica1`.`Especie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-practica1`.`Especie` (
  `id_especie` INT NOT NULL AUTO_INCREMENT,
  `nombre_cientifico` VARCHAR(45) NOT NULL,
  `nombre_comun` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `image_url` VARCHAR(100) NULL,
  PRIMARY KEY (`id_especie`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_especie_UNIQUE` ON `bd-practica1`.`Especie` (`id_especie` ASC);


-- -----------------------------------------------------
-- Table `bd-practica1`.`Area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-practica1`.`Area` (
  `id_area` INT NOT NULL AUTO_INCREMENT,
  `nombre_area` VARCHAR(45) NOT NULL,
  `extension` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_area`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idArea_UNIQUE` ON `bd-practica1`.`Area` (`id_area` ASC);


-- -----------------------------------------------------
-- Table `bd-practica1`.`Especie_Areas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-practica1`.`Especie_Areas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `especies_idEspecie` INT NOT NULL,
  `areas_idArea` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idArea`
    FOREIGN KEY (`areas_idArea`)
    REFERENCES `bd-practica1`.`Area` (`id_area`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `idEspecie`
    FOREIGN KEY (`especies_idEspecie`)
    REFERENCES `bd-practica1`.`Especie` (`id_especie`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `idEspecie_idx` ON `bd-practica1`.`Especie_Areas` (`especies_idEspecie` ASC);

CREATE INDEX `idArea` ON `bd-practica1`.`Especie_Areas` (`areas_idArea` ASC);


-- -----------------------------------------------------
-- Table `bd-practica1`.`Contratado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-practica1`.`Contratado` (
  `id_contratado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `tel_fijo` VARCHAR(9) NOT NULL,
  `tel_movil` VARCHAR(9) NOT NULL,
  `tipo` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_contratado`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idContratado_UNIQUE` ON `bd-practica1`.`Contratado` (`id_contratado` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- Insertions
-- -----------------------------------------------------

INSERT INTO `area` VALUES (5,'Valle alto','1800 ha'),(6,'Fuerte viento','1500 ha'),(7,'Rio sano','2000 ha');


INSERT INTO `contratado` VALUES (2,'Nuria','Jiménez Sánchez','913653487','643986754','Gestión'),(3,'Fernando','Álvarez Toledo','934572837','659345968','Vigilancia'),(9,'Alfonso','Rodriguez','914569392','694303244','Gestión');


INSERT INTO `especie` VALUES (8,'Sapo etiópico','Sapo','Animal','/img/especies/sapo.png'),(9,'Atelopus','Sapos stubfoot','Animal','/img/especies/atelopus.jpg'),(10,'Capensibufo','Sapo del Cabo','Animal','img/especies/capensibufo.jpg');


INSERT INTO `especie_areas` VALUES (22,8,5),(23,8,6),(24,8,7),(25,9,6),(26,9,6),(27,10,7);