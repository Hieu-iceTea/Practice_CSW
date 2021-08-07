# Created_by: Hieu_iceTea
# Created_at: 10:00 2021-08-03
# Updated_at: 10:15 2021-08-03

# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #
#                                           Create DataBase                                           #
# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #

# SET @DATABASE_Name = 'ABCShop';

# Create DataBase >> (Lúc nhập dữ liệu để deploy thì bỏ 2 dòng tạo DB này, nhớ đổi tên DB nữa nhé)
DROP DATABASE IF EXISTS `ABCShop`;
CREATE DATABASE IF NOT EXISTS `ABCShop` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE `ABCShop`;

SET time_zone = '+07:00';
ALTER DATABASE `ABCShop` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

# SET SQL_MODE = 'ALLOW_INVALID_DATES';

# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #
#                                            Create Tables                                            #
# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #

# Create Table users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users`
(
    `id`                  INT AUTO_INCREMENT,

    `restaurant_id`       INT UNSIGNED,

    `username`            VARCHAR(64) UNIQUE           NOT NULL,
    `email`               VARCHAR(64) UNIQUE           NOT NULL,
    `password`            VARCHAR(128)                 NOT NULL,

    `email_verified_at`   DATETIME,
    `verification_code`   VARCHAR(8)     DEFAULT NULL,
    `reset_password_code` VARCHAR(16)    DEFAULT NULL,
    `remember_token`      VARCHAR(128)   DEFAULT NULL,

    `image`               VARCHAR(128),
    `gender`              BOOLEAN,
    `name`                VARCHAR(64),
    `phone`               VARCHAR(16),
    `address`             VARCHAR(128),

    `wage`                DECIMAL(16, 2) DEFAULT 0     NOT NULL,

    `enabled`             BOOLEAN        DEFAULT FALSE NOT NULL,

    `created_by`          NVARCHAR(32)   DEFAULT 'Hieu_iceTea',
    `created_at`          TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    `updated_by`          NVARCHAR(32)   DEFAULT NULL,
    `updated_at`          TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    `version`             INT            DEFAULT 1,
    `deleted`             BOOLEAN        DEFAULT FALSE,

    PRIMARY KEY (`id`)
) ENGINE InnoDB;


# Create Table authorities
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE IF NOT EXISTS `authorities`
(
    `id`         INT AUTO_INCREMENT,

    `username`   VARCHAR(64)  NOT NULL,
    `authority`  VARCHAR(128) NOT NULL,

    `created_by` NVARCHAR(32) DEFAULT 'Hieu_iceTea',
    `created_at` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    `updated_by` NVARCHAR(32) DEFAULT NULL,
    `updated_at` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    `version`    INT          DEFAULT 1,
    `deleted`    BOOLEAN      DEFAULT FALSE,

    PRIMARY KEY (`id`)
) ENGINE InnoDB;


# Create Table employees
DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products`
(
    `id`         INT AUTO_INCREMENT,

    `name`       VARCHAR(64),
    `price`      DOUBLE(16, 2),
    `quantity`   INT,

    `created_by` NVARCHAR(32) DEFAULT 'Hieu_iceTea',
    `created_at` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    `updated_by` NVARCHAR(32) DEFAULT NULL,
    `updated_at` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    `version`    INT          DEFAULT 1,
    `deleted`    BOOLEAN      DEFAULT FALSE,

    PRIMARY KEY (`id`)
) ENGINE InnoDB;


# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #
#                                             Insert Data                                             #
# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #

# Default password: 123456

INSERT INTO users (id, restaurant_id, username, email, password, email_verified_at, image, gender, name, phone, address, enabled)
VALUES
(1, NULL, 'Customer', 'Customer@codedy.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'Customer.jpg', 2, 'Customer', '0868 6633 15', '8, Ton That Thuyet, Ha Noi, Viet Nam', TRUE),
(0, NULL, 'Staff', 'Staff@codedy.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'Staff.jpg', 1, 'Staff', '0868 6633 15', '8, Ton That Thuyet, Ha Noi, Viet Nam', TRUE);


INSERT INTO authorities (username, authority)
VALUES
('Customer', 'ROLE_Customer'),
('Staff', 'ROLE_Staff');


INSERT INTO products (id, name, price, quantity)
VALUES
(13, 'Nguyễn Đình Hiếu', 9999, 8686),
(12, 'Đặng Kim Thi', 9999, 8686),
(11, 'Nguyễn Đình Hiếu', 9999, 8686),
(10, 'Nông Phan Mạnh Hùng', 9999, 8686),
(9, 'Vũ Quang Huy', 9999, 8686),
(8, 'Nguyễn Trung Anh', 9999, 8686),
(7, 'CODEDY Customer', 9999, 8686),
(6, 'CODEDY Staff C', 9999, 8686),
(5, 'CODEDY Staff B', 9999, 8686),
(4, 'CODEDY Staff A', 9999, 8686),
(3, 'CODEDY Admin ReadOnly', 9999, 8686),
(2, 'CODEDY Admin', 9999, 8686),
(1, 'CODEDY Host', 9999, 8686);
