/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50726
Source Host           : localhost:3307
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2024-11-19 09:27:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for candidate
-- ----------------------------
DROP TABLE IF EXISTS `candidate`;
CREATE TABLE `candidate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of candidate
-- ----------------------------
INSERT INTO `candidate` VALUES ('1', '特朗普');
INSERT INTO `candidate` VALUES ('2', '哈里斯');

-- ----------------------------
-- Table structure for candidate_userinfo_tab
-- ----------------------------
DROP TABLE IF EXISTS `candidate_userinfo_tab`;
CREATE TABLE `candidate_userinfo_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `candidate_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of candidate_userinfo_tab
-- ----------------------------
INSERT INTO `candidate_userinfo_tab` VALUES ('1', '1', '1');
INSERT INTO `candidate_userinfo_tab` VALUES ('3', '3', '2');
INSERT INTO `candidate_userinfo_tab` VALUES ('7', '2', '2');
INSERT INTO `candidate_userinfo_tab` VALUES ('8', '4', '2');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'zhangsan', '123');
INSERT INTO `userinfo` VALUES ('2', 'lisi', '123');
INSERT INTO `userinfo` VALUES ('3', 'wangwu', '123');
INSERT INTO `userinfo` VALUES ('4', 'sunyi', '123');
