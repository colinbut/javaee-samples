create database sales_order_system;

/*
 * customer_payment_details > customer 1:1
 * customer > address M:1
 * customer > orders  1:M
 * orders > items M:M
 *  orders_items:
 *      - orders > orders_items 1:M
 *      - orders_items > items  M:1
 */

create table address(
  address_id int primary key auto_increment,
  house_flat_no int not null,
  street varchar(255) not null,
  postcode varchar(8) not null,
  city varchar(15) not null,
  country varchar(20) not null
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;


create table customer (
  customer_id int primary key auto_increment,
  customer_firstname varchar(50) not null,
  customer_lastname varchar(50) not null,
  customer_date_of_birth datetime not null,
  customer_email_address text not null,
  customer_address_id int not null,
  foreign key (customer_address_id) references address (address_id)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;


create table customer_payment_details (
  customer_payment_details_id int primary key auto_increment,
  customer_reference varchar(255) not null,
  customer_card_number varchar(16) not null,
  customer_card_expiry_date varchar(5) not null,
  -- reference customer here in this table so that a customer can not be foreced to have
  -- a payment detail upon setup of customer and that they can enter it at point of purchasing order
  -- at the latest
  customer_id int not null,
  foreign key (customer_id) references customer (customer_id)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

create table orders (
  order_id int primary key auto_increment,
  customer_id int not null,
  foreign key (customer_id) references customer (customer_id)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

create table items (
  item_id int primary key auto_increment,
  item_name varchar(255) not null,
  item_price decimal not null
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

create table orders_items (
  order_id int,
  item_id int,
  primary key(order_id, item_id),
  foreign key (order_id) references orders (order_id),
  foreign key (item_id) references items (item_id)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;
