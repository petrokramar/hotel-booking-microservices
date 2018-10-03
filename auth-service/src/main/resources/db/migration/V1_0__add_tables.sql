-- DROP SCHEMA IF EXISTS AUTH_SERVICE_SCHEMA;
-- CREATE SCHEMA IF NOT EXISTS AUTH_SERVICE_SCHEMA;
-- SET SCHEMA AUTH_SERVICE_SCHEMA;

CREATE TABLE users (
    user_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(128) NOT NULL UNIQUE,
    password VARCHAR(256)NOT NULL,
    enabled BOOL NOT NULL
);