ALTER DATABASE `pyrodb` DEFAULT CHARACTER SET = utf8;
DROP TABLE IF EXISTS `pyrodb`.`reservation` ;
DROP TABLE IF EXISTS `pyrodb`.`user` ;
DROP TABLE IF EXISTS `pyrodb`.`room` ;

CREATE TABLE `pyrodb`.`user` (
    `login` VARCHAR(50) NOT NULL PRIMARY KEY,
    `name` VARCHAR(50)
);
