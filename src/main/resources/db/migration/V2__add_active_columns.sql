ALTER TABLE clients ADD active tinyint(1) DEFAULT 1;
ALTER TABLE orders ADD active tinyint(1) DEFAULT 1;
ALTER TABLE products ADD active tinyint(1) DEFAULT 1;