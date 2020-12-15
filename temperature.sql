CREATE TABLE `temperature` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `greenhouseNo` varchar(16) NOT NULL,
  `sensorNo` varchar(16) NOT NULL,
  `temperature` varchar(40) DEFAULT NULL,
  `humidity` varchar(40) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_greenhouseNosensorNo` (`greenhouseNo`,`sensorNo`)
) ENGINE=InnoDB AUTO_INCREMENT=4271 DEFAULT CHARSET=utf8;
