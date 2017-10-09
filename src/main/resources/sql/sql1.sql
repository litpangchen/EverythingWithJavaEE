CREATE TABLE `Transaction` (
  `txn_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `txn_date` DATE NOT NULL,
  `txn_total` DECIMAL(10,0) NOT NULL ,
  PRIMARY KEY (`txn_id`)
);

CREATE TABLE `Customer` (
  `txn_id` int(11) UNSIGNED NOT NULL,
  `cust_name` VARCHAR(20) NOT NULL DEFAULT '',
  `cust_email` VARCHAR(20) DEFAULT NULL,
  `cust_address` VARCHAR(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`txn_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`txn_id`)
  REFERENCES `Transaction` (`txn_id`)
)