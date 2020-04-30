-- 用户表（APP）
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `gender` int(2) NOT NULL commit '性别'
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户';

-- 好友组
CREATE TABLE `tb_cont_group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) NOT NULL COMMENT '组名',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;



-- 祝福短信
CREATE TABLE `tb_bless_info` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `info_contents` varchar(200) NOT NULL COMMENT '祝福短线',
  PRIMARY KEY (`info_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;































































