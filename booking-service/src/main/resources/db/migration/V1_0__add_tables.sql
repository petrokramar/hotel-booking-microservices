DROP SCHEMA IF EXISTS BOOKING_HOTELS_SCHEMA;
CREATE SCHEMA IF NOT EXISTS BOOKING_HOTELS_SCHEMA;
SET SCHEMA BOOKING_HOTELS_SCHEMA;

CREATE TABLE IF NOT EXISTS users
(
  username varchar(50) PRIMARY KEY,
  password varchar(100) NOT NULL,
  enabled boolean DEFAULT true,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
);

CREATE TABLE IF NOT EXISTS authorities
(
 id SERIAL PRIMARY KEY,
  username varchar(50) REFERENCES users(username),
  authority varchar(50) NOT NULL,

);

 CREATE TABLE IF NOT EXISTS countries
(
  id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS cities
(
  id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL,
  country_id integer REFERENCES countries(id)
);

CREATE TABLE IF NOT EXISTS hotels
(
  id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL,
  city_id integer REFERENCES cities(id),
  category varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS room_categories
(
  id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL,
  description varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS rooms
(
  id SERIAL PRIMARY KEY,
  number integer NOT NULL,
  hotel_id integer references hotels(id),
  room_category_id integer REFERENCES room_categories(id),
  price integer NOT NULL,
  persons integer NOT NULL
);

CREATE TABLE IF NOT EXISTS booking
(
  id SERIAL PRIMARY KEY,
  room_id integer REFERENCES rooms(id),
  user_username varchar(50) REFERENCES users(username),
  total_sum integer NOT NULL,
  persons integer NOT NULL,
  check_in TIMESTAMP NOT NULL,
  check_out TIMESTAMP NOT NULL
);