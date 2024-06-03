create database demo_3t;
use demo_3t;
CREATE TABLE `demo_3t`.`category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `created_by` VARCHAR(45) NULL,
  `created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_by` VARCHAR(45) NULL,
  `modify_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

CREATE TABLE `demo_3t`.`product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `image_name` VARCHAR(45) NULL,
  `image_data` MEDIUMBLOB NOT NULL,
  `created_by` VARCHAR(45) NULL,
  `created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_by` VARCHAR(45) NULL,
  `modify_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `category_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `category_id_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `demo_3t`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);