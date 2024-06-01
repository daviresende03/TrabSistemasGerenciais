/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 80032
Source Host           : localhost:3307
Source Database       : pallato

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2024-06-01 09:54:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `waiter_id` int NOT NULL,
  `discount_total` double(15,4) NOT NULL,
  `order_total` double(15,4) NOT NULL,
  `observation` varchar(120) NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_1` (`customer_id`),
  KEY `fk_order_2` (`waiter_id`),
  CONSTRAINT `fk_order_1` FOREIGN KEY (`customer_id`) REFERENCES `person` (`person_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_2` FOREIGN KEY (`waiter_id`) REFERENCES `person` (`person_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `order_item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` double(15,4) NOT NULL,
  `sale_price` double(15,4) NOT NULL,
  `total_item` double(15,4) NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `fk_order_item_1` (`order_id`),
  KEY `fk_order_item_2` (`product_id`),
  CONSTRAINT `fk_order_item_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_item_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `person_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `document` varchar(14) NOT NULL,
  `type` int NOT NULL,
  `address_street` varchar(50) NOT NULL,
  `address_number` varchar(10) NOT NULL,
  `address_neighborhood` varchar(20) NOT NULL,
  `address_city` varchar(30) NOT NULL,
  `address_state` varchar(30) NOT NULL,
  `address_postal_code` varchar(8) NOT NULL,
  `address_country` varchar(30) NOT NULL,
  `birth_date` date NOT NULL,
  `observation` varchar(100) NOT NULL,
  `customer` int NOT NULL,
  `staff` int NOT NULL,
  `supplier` int NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `uk_person_1` (`document`) USING BTREE,
  KEY `k_person_1` (`name`) USING BTREE,
  KEY `k_person_2` (`type`) USING BTREE,
  KEY `k_person_3` (`customer`) USING BTREE,
  KEY `k_person_4` (`staff`) USING BTREE,
  KEY `k_person_5` (`supplier`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of person
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_unit_id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` int NOT NULL,
  `cost_price` double(15,4) NOT NULL,
  `sale_price` double(15,4) NOT NULL,
  `stock` double(15,4) NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_product_1` (`product_unit_id`),
  KEY `k_product_1` (`stock`) USING BTREE,
  CONSTRAINT `fk_product_1` FOREIGN KEY (`product_unit_id`) REFERENCES `product_unit` (`product_unit_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `product_unit`
-- ----------------------------
DROP TABLE IF EXISTS `product_unit`;
CREATE TABLE `product_unit` (
  `product_unit_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `symbol` varchar(6) NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  PRIMARY KEY (`product_unit_id`),
  UNIQUE KEY `uk_product_unit_1` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_unit
-- ----------------------------
