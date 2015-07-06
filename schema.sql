DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `event` varchar(45) DEFAULT NULL,
      `b_id_1` varchar(45) DEFAULT NULL,
      `b_id_2` smallint(6) DEFAULT NULL,
      `b_id_3` smallint(6) DEFAULT NULL,
      `range` float DEFAULT NULL,
      `ts` timestamp NULL DEFAULT NULL,
      `d_id` varchar(37) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `b_id_1` (`b_id_1`),
      KEY `b_ids` (`b_id_1`,`b_id_2`,`b_id_3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
