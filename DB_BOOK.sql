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

 Date: 01/06/2022 17:32:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DB_BOOK
-- ----------------------------
DROP TABLE IF EXISTS `DB_BOOK`;
CREATE TABLE `DB_BOOK`  (
  `bid` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of DB_BOOK
-- ----------------------------
INSERT INTO `DB_BOOK` VALUES (1, '深入理解java虚拟机', '了解java虚拟机');
INSERT INTO `DB_BOOK` VALUES (2, 'java并发编程的艺术', 'java并发编程');
INSERT INTO `DB_BOOK` VALUES (3, '数据结构', '数据结构');
INSERT INTO `DB_BOOK` VALUES (4, '编译原理', '底层代码');

SET FOREIGN_KEY_CHECKS = 1;
