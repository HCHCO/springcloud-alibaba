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

 Date: 01/06/2022 17:32:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DB_USER
-- ----------------------------
DROP TABLE IF EXISTS `DB_USER`;
CREATE TABLE `DB_USER`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of DB_USER
-- ----------------------------
INSERT INTO `DB_USER` VALUES (1, '小明', 18, '男');
INSERT INTO `DB_USER` VALUES (2, '小红', 21, '女');
INSERT INTO `DB_USER` VALUES (3, '小刚', 19, '男');

SET FOREIGN_KEY_CHECKS = 1;
