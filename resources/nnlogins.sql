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

 Date: 23/12/2018 00:28:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nnlogins
-- ----------------------------
DROP TABLE IF EXISTS `nnlogins`;
CREATE TABLE `nnlogins`  (
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pid` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nnlogins
-- ----------------------------
INSERT INTO `nnlogins` VALUES ('Administrator', 'administrator', 0);
INSERT INTO `nnlogins` VALUES ('Administratorq', '12345', 1);
INSERT INTO `nnlogins` VALUES ('Administratorq66', '12345', 2);
INSERT INTO `nnlogins` VALUES ('12345', '12345', 3);

SET FOREIGN_KEY_CHECKS = 1;
