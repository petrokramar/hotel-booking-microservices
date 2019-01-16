-- SET SCHEMA AUTH_SERVICE_SCHEMA;
INSERT INTO users (user_id, username, password, enabled, email, activation_code) VALUES
	  ('1', 'max', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'max@example.com', ''),
	  ('2', 'john', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'john@example.com', ''),
	  ('3', 'bill', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'bill@example.com', ''),
	  ('4', 'user', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'user@example.com', '');

insert into user_role (user_id, role) VALUES
    (1, 'USER'), (1, 'ADMIN'), (2, 'USER'), (3, 'USER'), (4, 'USER');