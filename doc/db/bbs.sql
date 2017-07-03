/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-04-20 15:35:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_board
-- ----------------------------
DROP TABLE IF EXISTS `t_board`;
CREATE TABLE `t_board` (
  `board_id` int(11) NOT NULL DEFAULT '0',
  `board_name` varchar(255) NOT NULL COMMENT '板块名称',
  `board_desc` varchar(255) NOT NULL COMMENT '板块描述',
  `topic_num` int(11) NOT NULL COMMENT '板块主题数',
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_board
-- ----------------------------

-- ----------------------------
-- Table structure for t_board_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_board_manager`;
CREATE TABLE `t_board_manager` (
  `board_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`board_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_board_manager
-- ----------------------------

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post` (
  `post_id` int(11) NOT NULL,
  `board_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_type` tinyint(4) NOT NULL DEFAULT '2' COMMENT '帖子类型 1：主题帖；2回复帖',
  `post_title` varchar(50) NOT NULL COMMENT '贴子标题',
  `post_text` text NOT NULL COMMENT '贴子内容',
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_post
-- ----------------------------

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `topic_id` int(11) NOT NULL,
  `board_id` int(11) NOT NULL,
  `topic_title` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_post` datetime DEFAULT NULL COMMENT '最后回复时间',
  `topic_view` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `topic_replies` int(11) NOT NULL DEFAULT '0' COMMENT '回复次数',
  `digest` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否精品 0:非精品；1:精品',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_topic
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_type` tinyint(4) DEFAULT '1' COMMENT '用户类型 1:普通会员 2:版块管理员 3:论坛管理员',
  `locked` tinyint(4) DEFAULT '0' COMMENT '是否被锁定',
  `credit` int(11) DEFAULT '0',
  `lastvisit` datetime DEFAULT NULL COMMENT '上次登录时间',
  `lastip` varchar(255) DEFAULT NULL COMMENT '上次登录地址',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
