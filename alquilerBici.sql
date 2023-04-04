-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema alquilerBici
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema alquilerBici
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `alquilerBici` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `alquilerBici` ;

-- -----------------------------------------------------
-- Table `alquilerBici`.`bici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alquilerBici`.`bici` (
  `idbici` INT NOT NULL,
  `disponibilidad` TINYINT NOT NULL,
  PRIMARY KEY (`idbici`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `alquilerBici`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alquilerBici`.`usuario` (
  `idusuario` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `bici_idbici` INT ,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuario_bici1_idx` (`bici_idbici` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_bici1`
    FOREIGN KEY (`bici_idbici`)
    REFERENCES `alquilerBici`.`bici` (`idbici`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `alquilerBici`.`bici` (`idbici`, `disponibilidad`) VALUES ('1', '0');
INSERT INTO `alquilerBici`.`bici` (`idbici`, `disponibilidad`) VALUES ('2', '0');
INSERT INTO `alquilerBici`.`bici` (`idbici`, `disponibilidad`) VALUES ('3', '0');
INSERT INTO `alquilerBici`.`bici` (`idbici`, `disponibilidad`) VALUES ('4', '0');
INSERT INTO `alquilerBici`.`bici` (`idbici`, `disponibilidad`) VALUES ('5', '0');
INSERT INTO `alquilerBici`.`bici` (`idbici`, `disponibilidad`) VALUES ('6', '0');


INSERT INTO `alquilerBici`.`usuario` (`idusuario`, `nombre`) VALUES ('1', 'Alvaro');
INSERT INTO `alquilerBici`.`usuario` (`idusuario`, `nombre`) VALUES ('2', 'Marcelo');
INSERT INTO `alquilerBici`.`usuario` (`idusuario`, `nombre`) VALUES ('3', 'Moisés');
INSERT INTO `alquilerBici`.`usuario` (`idusuario`, `nombre`) VALUES ('4', 'Alba');
INSERT INTO `alquilerBici`.`usuario` (`idusuario`, `nombre`) VALUES ('5', 'Marta');
INSERT INTO `alquilerBici`.`usuario` (`idusuario`, `nombre`) VALUES ('6', 'Maria');
INSERT INTO `alquilerBici`.`usuario` (`idusuario`, `nombre`) VALUES ('7', 'Luis');

