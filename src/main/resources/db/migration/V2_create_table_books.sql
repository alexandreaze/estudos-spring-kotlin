CREATE TABLE `books` (
     `id` bigint(20) NOT NULL AUTO_INCREMENT,
     `name` varchar(255) DEFAULT NULL,
     `status` varchar(255) DEFAULT NULL,
     `price` decimal(10,2) DEFAULT NULL,
     `customer_id` bigint(11) NOT NULL,
     PRIMARY KEY (`id`),
     KEY `fk_books_customers` (`customer_id`),
     CONSTRAINT `fk_books_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;