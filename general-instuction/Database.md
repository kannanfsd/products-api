-- -----------------------------------------------------
-- Schema panel-task
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `panel-task`;

CREATE SCHEMA `panel-taske`;
USE `panel-task` ;

-- -----------------------------------------------------
-- Table `panel-task`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `panel-task`.`category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  `priority` INT(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `panel-task`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `panel-task`.`product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,  
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `price` DECIMAL(13,2) DEFAULT NULL,  
  `quantity` INT(11) DEFAULT NULL,
  `created_at` DATETIME(6) DEFAULT NULL,
  `updated_at` DATETIME(6) DEFAULT NULL,
  `category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO category(name,priority) VALUES ('Essential', 1);
INSERT INTO category(name,priority) VALUES ('Cosmetics', 2);

INSERT INTO product (name, description, quantity, price, category_id, created_at)
VALUES ('JavaScript - The Fun Parts', 'Learn JavaScript',100,19.99,1,NOW());

INSERT INTO product (name, description, quantity, price, category_id, created_at)
VALUES ('Spring Framework Tutorial', 'Learn Spring',100,29.99,1,NOW());

INSERT INTO product (name, description, quantity, price, category_id, created_at)
VALUES ('Kubernetes - Deploying Containers', 'Learn Kubernetes',100,24.99,1,NOW());

INSERT INTO product (name, description, quantity, price, category_id, created_at)
VALUES ('Internet of Things (IoT) - Getting Started', 'Learn IoT',100,29.99,1,NOW());

INSERT INTO product (name, description, quantity, price, category_id, created_at)
VALUES ('The Go Programming Language: A to Z', 'Learn Go',100,24.99,1,NOW());

Products API

POST: http://localhost:8081/api/products
GET: http://localhost:8081/api/products
GET: http://localhost:8081/api/products/{id}
PUT: http://localhost:8081/api/products
DELETE: http://localhost:8081/api/products/{id}
