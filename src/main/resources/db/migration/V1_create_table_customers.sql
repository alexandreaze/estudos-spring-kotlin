CREATE TABLE `customers` (
     `id` bigint(20) NOT NULL AUTO_INCREMENT,
     `email` varchar(255) DEFAULT NULL,
     `name` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;