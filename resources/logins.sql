/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : redrock

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 21/12/2018 16:50:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for logins
-- ----------------------------
DROP TABLE IF EXISTS `logins`;
CREATE TABLE `logins`  (
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logins
-- ----------------------------
INSERT INTO `logins` VALUES ('起始账号', 'Administrator', 'administrator', 0);
INSERT INTO `logins` VALUES ('123', '123', '123', 2);
INSERT INTO `logins` VALUES ('5555555', '321', '321', 3);
INSERT INTO `logins` VALUES ('5555555', '555', '555', 4);

SET FOREIGN_KEY_CHECKS = 1;
