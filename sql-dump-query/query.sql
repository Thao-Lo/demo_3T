create database demo_3t;
use demo_3t;
CREATE TABLE `demo_3t`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `priority` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`));
INSERT INTO `demo_3t`.`category` (`id`, `name`, `priority`) VALUES ('1', 'Food', '1');
