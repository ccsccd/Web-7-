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

 Date: 21/12/2018 16:50:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `id` int(11) DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `message` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES (2, '123', '2018-12-21', '这是我的第一次留言', '123456789123456789');
INSERT INTO `messages` VALUES (2, '123', '2018-12-21', '这是我的第一次留言', '6666666666666');
INSERT INTO `messages` VALUES (3, '321', '2018-12-21', '这是我的第一次留言22222222222', '6666666666666666666666666666');
INSERT INTO `messages` VALUES (3, '321', '2018-12-21', '这是我的第一次留言', '6666666666666');
INSERT INTO `messages` VALUES (3, '321', '2018-12-21', '这是我的第一次留言', '333');
INSERT INTO `messages` VALUES (2, '123', '2018-12-21', '22222', '333');
INSERT INTO `messages` VALUES (2, '123', '2018-12-21', '22222', '33333');
INSERT INTO `messages` VALUES (2, '123', '2018-12-21', '22222', '6666999');

SET FOREIGN_KEY_CHECKS = 1;
