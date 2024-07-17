-- Adminer 4.8.0 MySQL 8.0.36 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

CREATE DATABASE `avis-utilisateurs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION = 'N' */;
USE `avis-utilisateurs`;

DROP TABLE IF EXISTS `avis`;
CREATE TABLE `avis`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `message`        varchar(255) DEFAULT NULL,
    `statut`         varchar(255) DEFAULT NULL,
    `utilisateur_id` int          DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKblk72jlw8skbs4g9u1xibrpxh` (`utilisateur_id`),
    CONSTRAINT `FKblk72jlw8skbs4g9u1xibrpxh` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`      int NOT NULL AUTO_INCREMENT,
    `libelle` enum ('ADMINISTRATEUR','MANAGER','UTILISATEUR') DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `role` (`id`, `libelle`)
VALUES (1, 'ADMINISTRATEUR'),
       (2, 'MANAGER');

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur`
(
    `id`           int    NOT NULL AUTO_INCREMENT,
    `actif`        bit(1) NOT NULL,
    `email`        varchar(255) DEFAULT NULL,
    `mot_de_passe` varchar(255) DEFAULT NULL,
    `nom`          varchar(255) DEFAULT NULL,
    `role_id`      int          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_g7tx9d1p09c00xnl7u2g1p6yp` (`role_id`),
    CONSTRAINT `FKaqe8xtajee4k0wlqrvh2pso4l` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `utilisateur` (`id`, `actif`, `email`, `mot_de_passe`, `nom`, `role_id`)
VALUES (1, CONV('1', 2, 10) + 0, 'achille.mbougueng@chillo.tech',
        '$2a$10$PqthNA.vzk5AjxFrdlPkBu6Pf.p/Bc1eMVBGZaHN.yjPCk2C/2xeG', 'admin', 1),
       (2, CONV('1', 2, 10) + 0, 'manager@chillo.tech', '$2a$10$/9kg9z525RPEnlYcUzkC4.Gx82ZvI1D3uuZ70hw6fgiUaHLzz6pE2',
        'manager', 2);

DROP TABLE IF EXISTS `validation`;
CREATE TABLE `validation`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `activation`     datetime(6)  DEFAULT NULL,
    `code`           varchar(255) DEFAULT NULL,
    `creation`       datetime(6)  DEFAULT NULL,
    `expiration`     datetime(6)  DEFAULT NULL,
    `utilisateur_id` int          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_lbpw0tm5eu215mqoagm7wte1c` (`utilisateur_id`),
    CONSTRAINT `FKg0vmxkmj7wfai4s41fytetn9n` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- 2024-07-17 05:34:02
