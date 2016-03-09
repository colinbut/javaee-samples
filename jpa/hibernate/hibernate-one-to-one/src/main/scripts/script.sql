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

