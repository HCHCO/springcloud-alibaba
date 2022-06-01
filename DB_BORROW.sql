/*
 Navicat Premium Data Transfer

 Source Server         : book
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : 47.115.20.174:6006
 Source Schema         : springcloud

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 01/06/2022 17:32:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DB_BORROW
-- ----------------------------
DROP TABLE IF EXISTS `DB_BORROW`;
CREATE TABLE `DB_BORROW`  (
  `id` int(11) NOT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `bid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_bid_uid`(`uid`, `bid`) USING BTREE,
  INDEX `f_bid`(`bid`) USING BTREE,
  CONSTRAINT `f_bid` FOREIGN KEY (`bid`) REFERENCES `DB_BOOK` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `f_uid` FOREIGN KEY (`uid`) REFERENCES `DB_USER` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of DB_BORROW
-- ----------------------------
INSERT INTO `DB_BORROW` VALUES (1, 1, 1);
INSERT INTO `DB_BORROW` VALUES (2, 1, 3);

SET FOREIGN_KEY_CHECKS = 1;
