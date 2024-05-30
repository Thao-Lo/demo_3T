create database demo_3t;
use demo_3t;
CREATE TABLE `demo_3t`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `priority` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`));
INSERT INTO `demo_3t`.`category` (`id`, `name`, `priority`) VALUES ('1', 'Food', '1');

CREATE TABLE `demo_3t`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `category_id_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `demo_3t`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);