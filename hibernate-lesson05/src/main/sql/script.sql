/*
  The Address table was used in some previous examples. It has a foreign key based
  relationship with User table, so it should be removed first. 
*/
DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS User;

CREATE TABLE User (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  createdDate DATE NOT NULL
);

CREATE TABLE Comment (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  text VARCHAR(500) NOT NULL,
  userId INTEGER NOT NULL,
  CONSTRAINT comment_user_fk FOREIGN KEY (userId) REFERENCES User(id)
);

INSERT INTO User (id, name, createdDate) VALUES (1, 'shamim', '2013-04-03');
INSERT INTO Comment (text, userId) VALUES ('In God we trust, others must pay cash', 1);
INSERT INTO Comment (text, userId) VALUES ('There is no place like www.home.com', 1);