DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS User;

CREATE TABLE User (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  createdDate DATE NOT NULL
);

CREATE TABLE Address (
  user_id INTEGER NOT NULL,
  street VARCHAR(50) NOT NULL,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50),
  country VARCHAR(50) NOT NULL,
  CONSTRAINT address_pk PRIMARY KEY (user_id),
  CONSTRAINT address_fk_user_id FOREIGN KEY (user_id) REFERENCES User(id)
);

INSERT INTO User (id, name, createdDate) VALUES (1, 'shamim', '2013-04-03');
INSERT INTO Address (user_id, Street, City, State, Country) VALUES (1, '14/142 Herring Road', 'Sydney', 'NSW', 'Australia');