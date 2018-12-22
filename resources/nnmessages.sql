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

 Date: 23/12/2018 00:28:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nnmessages
-- ----------------------------
DROP TABLE IF EXISTS `nnmessages`;
CREATE TABLE `nnmessages`  (
  `id` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `message` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nnmessages
-- ----------------------------
INSERT INTO `nnmessages` VALUES (0, 0, 'Administrator', '2018-12-22', '0', '0');
INSERT INTO `nnmessages` VALUES (1, 3, '12345', '2018-12-22', 'biaoti', 'neirong');
INSERT INTO `nnmessages` VALUES (2, 3, '12345', '2018-12-22', 'biaoti2', 'neirong');
INSERT INTO `nnmessages` VALUES (3, 3, '12345', '2018-12-22', NULL, 'neirong');
INSERT INTO `nnmessages` VALUES (4, 3, '12345', '2018-12-22', NULL, NULL);
INSERT INTO `nnmessages` VALUES (5, 3, '12345', '2018-12-22', 'biaoti2', 'neirong');

SET FOREIGN_KEY_CHECKS = 1;
