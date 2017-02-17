
DROP TABLE IF EXISTS `thread_mark`;
CREATE TABLE `thread_mark` (
  `mark_id` int(11) NOT NULL AUTO_INCREMENT,
  `host` varchar(255) NOT NULL DEFAULT '',
  `thread_name` varchar(255) NOT NULL DEFAULT '',
  `thread_id` varchar(255) NOT NULL DEFAULT '',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0:Readly,1:Running,2:Done,3:Failed',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `start_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开始时间',
  `done_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '完成时间',
  PRIMARY KEY (`mark_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线程记录器';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `user_type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '0:管理员,1:普通用户',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `website`;
CREATE TABLE `website` (
  `website_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `host` varchar(255) NOT NULL DEFAULT '',
  `url` text NOT NULL,
  `title` varchar(255) NOT NULL DEFAULT '',
  `head` text NOT NULL,
  `body` text NOT NULL,
  `content` text NOT NULL COMMENT 'æ­£æ–‡å†…å®¹',
  `create_time` datetime NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`website_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22694 DEFAULT CHARSET=utf8;