-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cerrado_sic
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cerrado_sic` ;

-- -----------------------------------------------------
-- Schema cerrado_sic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cerrado_sic` DEFAULT CHARACTER SET utf8 ;
USE `cerrado_sic` ;

-- -----------------------------------------------------
-- Table `cerrado_sic`.`aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`aluno` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`aluno` (
  `idt_aluno` INT NOT NULL AUTO_INCREMENT,
  `nme_aluno` VARCHAR(200) NOT NULL,
  `observacao` VARCHAR(1024) NULL,
  PRIMARY KEY (`idt_aluno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrado_sic`.`professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`professor` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`professor` (
  `idt_professor` INT NOT NULL AUTO_INCREMENT,
  `nme_professor` VARCHAR(200) NOT NULL,
  `cod_cref_professor` VARCHAR(6) NOT NULL,
  `observacao` VARCHAR(1024) NULL,
  PRIMARY KEY (`idt_professor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrado_sic`.`especialidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`especialidade` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`especialidade` (
  `idt_especialdiade` INT NOT NULL AUTO_INCREMENT,
  `nme_especialidade` VARCHAR(200) NOT NULL,
  `dsc_especialidade` VARCHAR(200) NULL,
  PRIMARY KEY (`idt_especialdiade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrado_sic`.`modalidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`modalidade` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`modalidade` (
  `idt_modalidade` INT NOT NULL AUTO_INCREMENT,
  `nme_modalidade` VARCHAR(200) NOT NULL,
  `dsc_modalidade` VARCHAR(200) NULL,
  PRIMARY KEY (`idt_modalidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrado_sic`.`mensalidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`mensalidade` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`mensalidade` (
  `idt_mensalidade` INT NOT NULL AUTO_INCREMENT,
  `dta_mes_mensalidade` DATE NOT NULL,
  `vlr_mensalidade` VARCHAR(45) NULL,
  PRIMARY KEY (`idt_mensalidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrado_sic`.`mes_matricula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`mes_matricula` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`mes_matricula` (
  `idt_mes_matricula` INT NOT NULL AUTO_INCREMENT,
  `dta_mes_matricula` DATE NOT NULL,
  `flg_pago` TINYINT(1) NOT NULL,
  `idt_aluno` INT NOT NULL,
  `idt_mensalidade` INT NOT NULL,
  PRIMARY KEY (`idt_mes_matricula`),
  INDEX `fk_mes_matricula_aluno1_idx` (`idt_aluno` ASC),
  INDEX `fk_mes_matricula_mensalidade1_idx` (`idt_mensalidade` ASC),
  CONSTRAINT `fk_mes_matricula_aluno1`
    FOREIGN KEY (`idt_aluno`)
    REFERENCES `cerrado_sic`.`aluno` (`idt_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mes_matricula_mensalidade1`
    FOREIGN KEY (`idt_mensalidade`)
    REFERENCES `cerrado_sic`.`mensalidade` (`idt_mensalidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrado_sic`.`leciona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`leciona` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`leciona` (
  `idt_professor` INT NOT NULL,
  `idt_modalidade` INT NOT NULL,
  PRIMARY KEY (`idt_professor`, `idt_modalidade`),
  INDEX `fk_professor_has_modalidade_modalidade1_idx` (`idt_modalidade` ASC),
  INDEX `fk_professor_has_modalidade_professor_idx` (`idt_professor` ASC),
  CONSTRAINT `fk_professor_has_modalidade_professor`
    FOREIGN KEY (`idt_professor`)
    REFERENCES `cerrado_sic`.`professor` (`idt_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_has_modalidade_modalidade1`
    FOREIGN KEY (`idt_modalidade`)
    REFERENCES `cerrado_sic`.`modalidade` (`idt_modalidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrado_sic`.`curriculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`curriculo` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`curriculo` (
  `idt_professor` INT NOT NULL,
  `idt_especialdiade` INT NOT NULL,
  PRIMARY KEY (`idt_professor`, `idt_especialdiade`),
  INDEX `fk_professor_has_especialidade_especialidade1_idx` (`idt_especialdiade` ASC),
  INDEX `fk_professor_has_especialidade_professor1_idx` (`idt_professor` ASC),
  CONSTRAINT `fk_professor_has_especialidade_professor1`
    FOREIGN KEY (`idt_professor`)
    REFERENCES `cerrado_sic`.`professor` (`idt_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_has_especialidade_especialidade1`
    FOREIGN KEY (`idt_especialdiade`)
    REFERENCES `cerrado_sic`.`especialidade` (`idt_especialdiade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrado_sic`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cerrado_sic`.`user` ;

CREATE TABLE IF NOT EXISTS `cerrado_sic`.`user` (
  `idt_user` INT NOT NULL,
  `nme_user` VARCHAR(45) NULL,
  `psw_user` VARCHAR(45) NULL,
  PRIMARY KEY (`idt_user`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

