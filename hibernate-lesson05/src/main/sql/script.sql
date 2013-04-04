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
  user_id INTEGER NOT NULL,
  CONSTRAINT comment_user_fk FOREIGN KEY (user_id) REFERENCES User(id)
);

INSERT INTO User (id, name, createdDate) VALUES (1, 'shamim', '2013-04-03');
INSERT INTO Comment (text, user_id) VALUES ('In God we trust, others must pay cash', 1);
INSERT INTO Comment (text, user_id) VALUES ('There is no place like www.home.com', 1);