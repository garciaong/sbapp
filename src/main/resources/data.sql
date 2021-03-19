INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO users (email, username, full_name, password, enabled) VALUES ('admin@bpl.com.uk', 'admin', 'Administrator' , '$2a$10$GiVWFxYGgmPKyC13V7GgZeKOcYC.V9XKvmYDZVPzHq5CcTdBxJi/i', '1');
INSERT INTO users (email, username, full_name, password, enabled) VALUES ('user@bpl.com.uk', 'user', 'User' , '$2a$10$GiVWFxYGgmPKyC13V7GgZeKOcYC.V9XKvmYDZVPzHq5CcTdBxJi/i', '1');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);