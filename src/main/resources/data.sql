INSERT INTO USER(username, password, enabled) values ('admin', 'admin', true);
INSERT INTO USER(username, password, enabled) values ('user', 'user', true);
INSERT INTO USER_ROLE(username, role) values ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('user', 'ROLE_USER');