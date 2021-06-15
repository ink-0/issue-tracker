ALTER DATABASE `pyrodb` DEFAULT CHARACTER SET = utf8mb4;
DROP TABLE IF EXISTS `pyrodb`.`user` ;

CREATE TABLE `pyrodb`.`user` (
    email VARCHAR(50) NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    avatarUrl VARCHAR(300)
);
