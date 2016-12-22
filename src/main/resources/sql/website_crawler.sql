DROP TABLE IF EXISTS `thread_mark`;
CREATE TABLE `thread_mark` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `host` varchar(255) NOT NULL DEFAULT '',
  `thread_name` varchar(255) NOT NULL DEFAULT '',
  `thread_id` varchar(255) NOT NULL DEFAULT '',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0:Readly,1:Running,2:Done',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `start_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开始时间',
  `done_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '完成时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线程记录器';

DROP TABLE IF EXISTS `website`;
CREATE TABLE `website` (
  `website_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `host` varchar(255) NOT NULL DEFAULT '',
  `url` text NOT NULL,
  `title` varchar(255) NOT NULL DEFAULT '',
  `head` text NOT NULL,
  `body` text NOT NULL,
  `content` text NOT NULL COMMENT '正文内容',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`website_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7341 DEFAULT CHARSET=utf8;
