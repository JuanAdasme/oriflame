CREATE TABLE products(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  code varchar(10) NOT NULL,
  name varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  price int(6) NOT NULL,
  stock int(3) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE sales(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  discount_price int(6) NOT NULL,
  active tinyint(1) NOT NULL,
  limit_date date NOT NULL,
  product_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (product_id) REFERENCES products(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE product_details(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  expiration_date date NOT NULL,
  product_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (product_id) REFERENCES products(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE clients(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE orders(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  total_price int(6) NOT NULL,
  client_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (client_id) REFERENCES clients(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE product_orders(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  product_detail_id bigint(20) NOT NULL,
  order_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (product_detail_id) REFERENCES product_details(id),
  FOREIGN KEY (order_id) REFERENCES orders(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
