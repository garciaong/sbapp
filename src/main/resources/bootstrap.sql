DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users_roles;

CREATE TABLE users (
  id int(10) NOT NULL AUTO_INCREMENT,
  email varchar(45) NOT NULL,
  username varchar(45) NOT NULL,
  full_name varchar(45) NOT NULL,
  password varchar(64) NOT NULL,
  enabled tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email_UNIQUE (email),
  UNIQUE KEY email_UNIQUE (username)
);
 
CREATE TABLE roles (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  PRIMARY KEY (id)
);
 
CREATE TABLE users_roles (
  user_id int(10) NOT NULL,
  role_id int(10) NOT NULL,
  CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('CREATOR');
INSERT INTO roles (name) VALUES ('EDITOR');
INSERT INTO roles (name) VALUES ('ADMIN');

INSERT INTO users (email, username, full_name, password, enabled) VALUES ('admin@sbapp.com', 'admin', 'Administrator' , '$2a$10$5HdjQWrKHUBy8NuTrbDSAe0KYGWGpDQZNFO6LIJ3jBRhgCIMVlsLW', '1');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 4);