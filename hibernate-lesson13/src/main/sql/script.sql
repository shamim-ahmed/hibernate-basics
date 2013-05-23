DROP TABLE IF EXISTS User;

CREATE TABLE User (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  createdDate DATE NOT NULL
);

INSERT INTO User (id, name, createdDate) VALUES (1, 'shamim', '2013-04-03');
INSERT INTO User (id, name, createdDate) VALUES (2, 'linus', '2013-04-03');