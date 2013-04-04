DROP TABLE IF EXISTS User_Role;
DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS User;

CREATE TABLE User (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  createdDate DATE NOT NULL
);

CREATE TABLE Role (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(100),
  CONSTRAINT role_name_uniq UNIQUE (name)
);

CREATE TABLE User_Role(
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  CONSTRAINT user_role_pk PRIMARY KEY (user_id, role_id),
  CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES User(id),
  CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES Role(id)
);

INSERT INTO User (id, name, createdDate) VALUES (1, 'shamim', '2013-04-03');
INSERT INTO User (id, name, createdDate) VALUES (2, 'linus', '2013-04-03');
INSERT INTO Role (id, name, description) VALUES (1, 'admin', 'The administrator');
INSERT INTO Role (id, name, description) VALUES (2, 'user', 'An ordinary user');
INSERT INTO Role (id, name, description) VALUES (3, 'moderator', 'Content moderator');
INSERT INTO User_Role (user_id, role_id) VALUES (1, 1);
INSERT INTO User_Role (user_id, role_id) VALUES (1, 2);
INSERT INTO User_Role (user_id, role_id) VALUES (2, 2);
INSERT INTO User_Role (user_id, role_id) VALUES (2, 3);