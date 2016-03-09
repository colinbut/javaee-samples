DROP TABLE IF EXISTS Stock;

create table stock (
	stock_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	stock_code VARCHAR(10) NOT NULL,
	stock_name VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS Stock_Detail;

create table stock_detail (
	stock_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	company_name VARCHAR(100) NOT NULL,
	company_desc TEXT NOT NULL,
	remark VARCHAR(255) NOT NULL,
	listed_date DATETIME NOT NULL,
	CONSTRAINT fk_stock_id FOREIGN KEY (stock_id) REFERENCES stock(stock_id)
);

DROP TABLE IF EXISTS Stock_Daily_Record;

create table stock_daily_record (
	record_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	price_open FLOAT(6,2) DEFAULT NULL,
	price_close FLOAT(6,2) DEFAULT NULL,
	price_change FLOAT(6,2) DEFAULT NULL,
	volume BIGINT(20) UNSIGNED DEFAULT NULL,
	record_date DATETIME NOT NULL,
	stock_id INT(10) NOT NULL,
	CONSTRAINT fk_stock_transaction_stock_id FOREIGN KEY (stock_id) REFERENCES stock(stock_id)
	ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;