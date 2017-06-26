CREATE TABLE Order (
  orderID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  productID INT NOT NULL,
  units INT NOT NULL,
  FOREIGN KEY (productID) REFERENCES Product(productId)
);

CREATE TABLE Product (
  productId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name VARCHAR(30) NOT NULL,
  unitPrice DECIMAL(10, 0) NOT NULL,
  description VARCHAR(100),
  unitsInStock INT,
  unitsInOrder INT
);

CREATE TABLE User (
  username VARCHAR(40) NOT NULL PRIMARY KEY,
  password VARCHAR(40) NOT NULL,
  enabled TINYINT(4) NOT NULL DEFAULT 1,
  orderID INT,
  FOREIGN KEY (orderID) REFERENCES Order(orderID)
);

CREATE TABLE user_roles (
  user_role_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  role VARCHAR(45) NOT NULL,
  FOREIGN KEY (username) REFERENCES User(username)
);