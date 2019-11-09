/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : spring_boot_demo

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-10-14 22:29:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '邵帅', '123456');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `per` varchar(10) DEFAULT NULL,
  `salt` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'admin', 'a70fb5ad450d21dd69a63f77910fc005', null, '411ef6a97ee88d1b746c61a792283250');
INSERT INTO `user` VALUES ('4', 'ss', '7ae5244d73fa6dfa188438a4ab8dd69a', null, '161b368d021e8df823b80cb4407a7ad4');
