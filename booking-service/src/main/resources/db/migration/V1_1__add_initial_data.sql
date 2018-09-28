SET SCHEMA BOOKING_HOTELS_SCHEMA;
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('BobMarley', '{noop}1', 'true', 'Bob', 'Marley');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('JamesBond', '{noop}1', 'true', 'James', 'Bond');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('JohnLennon', '{noop}1', 'false', 'John', 'Lennon');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user1', '{noop}1', 'true', 'firstname user 1', 'lastname user 1');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user2', '{noop}1', 'true', 'firstname user 2', 'lastname user 2');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user3', '{noop}1', 'true', 'firstname user 3', 'lastname user 3');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user4', '{noop}1', 'true', 'firstname user 4', 'lastname user 4');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user5', '{noop}1', 'true', 'firstname user 5', 'lastname user 5');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user6', '{noop}1', 'true', 'firstname user 6', 'lastname user 6');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user7', '{noop}1', 'true', 'firstname user 7', 'lastname user 7');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user8', '{noop}1', 'true', 'firstname user 8', 'lastname user 8');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user9', '{noop}1', 'true', 'firstname user 9', 'lastname user 9');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user10', '{noop}1', 'true', 'firstname user 10', 'lastname user 10');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user11', '{noop}1', 'true', 'firstname user 11', 'lastname user 11');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user12', '{noop}1', 'true', 'firstname user 12', 'lastname user 12');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user13', '{noop}1', 'true', 'firstname user 13', 'lastname user 13');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user14', '{noop}1', 'true', 'firstname user 14', 'lastname user 14');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user15', '{noop}1', 'true', 'firstname user 15', 'lastname user 15');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user16', '{noop}1', 'true', 'firstname user 16', 'lastname user 16');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user17', '{noop}1', 'true', 'firstname user 17', 'lastname user 17');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user18', '{noop}1', 'true', 'firstname user 18', 'lastname user 18');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user19', '{noop}1', 'true', 'firstname user 19', 'lastname user 19');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user20', '{noop}1', 'true', 'firstname user 20', 'lastname user 20');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user21', '{noop}1', 'true', 'firstname user 21', 'lastname user 21');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user22', '{noop}1', 'true', 'firstname user 22', 'lastname user 22');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user23', '{noop}1', 'true', 'firstname user 23', 'lastname user 23');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user24', '{noop}1', 'true', 'firstname user 24', 'lastname user 24');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user25', '{noop}1', 'true', 'firstname user 25', 'lastname user 25');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user26', '{noop}1', 'true', 'firstname user 26', 'lastname user 26');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user27', '{noop}1', 'true', 'firstname user 27', 'lastname user 27');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user28', '{noop}1', 'true', 'firstname user 28', 'lastname user 28');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user29', '{noop}1', 'true', 'firstname user 29', 'lastname user 29');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('user30', '{noop}1', 'true', 'firstname user 30', 'lastname user 30');

INSERT INTO authorities(username, authority)
VALUES('BobMarley', 'ROLE_ADMIN');
INSERT INTO authorities(username, authority)
VALUES('BobMarley', 'ROLE_MANAGER');
INSERT INTO authorities(username, authority)
VALUES('BobMarley', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('JamesBond', 'ROLE_MANAGER');
INSERT INTO authorities(username, authority)
VALUES('JamesBond', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('JohnLennon', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user1', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user2', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user3', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user4', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user5', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user6', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user7', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user8', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user9', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user10', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user11', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user12', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user13', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user14', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user15', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user16', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user17', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user18', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user19', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user20', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user21', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user22', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user23', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user24', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user25', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user26', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user27', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user28', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user29', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('user30', 'ROLE_USER');

INSERT INTO room_categories(id, name, description)
VALUES('1', 'First', 'First category');
INSERT INTO room_categories(id, name, description)
VALUES('2', 'Second', 'Second category');
INSERT INTO room_categories(id, name, description)
VALUES('3', 'Third', 'Third category');

INSERT INTO countries(id, name)
VALUES('1', 'Egypt');
INSERT INTO countries(id, name)
VALUES('2', 'Turkey');
INSERT INTO countries(id, name)
VALUES('3', 'Tunisia');
INSERT INTO countries(id, name)
VALUES('4', 'Country 4');
INSERT INTO countries(id, name)
VALUES('5', 'Country 5');
INSERT INTO countries(id, name)
VALUES('6', 'Country 6');
INSERT INTO countries(id, name)
VALUES('7', 'Country 7');
INSERT INTO countries(id, name)
VALUES('8', 'Country 8');
INSERT INTO countries(id, name)
VALUES('9', 'Country 9');
INSERT INTO countries(id, name)
VALUES('10', 'Country 10');
INSERT INTO countries(id, name)
VALUES('11', 'Country 11');
INSERT INTO countries(id, name)
VALUES('12', 'Country 12');
INSERT INTO countries(id, name)
VALUES('13', 'Country 13');
INSERT INTO countries(id, name)
VALUES('14', 'Country 14');
INSERT INTO countries(id, name)
VALUES('15', 'Country 15');
INSERT INTO countries(id, name)
VALUES('16', 'Country 16');
INSERT INTO countries(id, name)
VALUES('17', 'Country 17');
INSERT INTO countries(id, name)
VALUES('18', 'Country 18');
INSERT INTO countries(id, name)
VALUES('19', 'Country 19');
INSERT INTO countries(id, name)
VALUES('20', 'Country 20');
INSERT INTO countries(id, name)
VALUES('21', 'Country 21');
INSERT INTO countries(id, name)
VALUES('22', 'Country 22');
INSERT INTO countries(id, name)
VALUES('23', 'Country 23');
INSERT INTO countries(id, name)
VALUES('24', 'Country 24');
INSERT INTO countries(id, name)
VALUES('25', 'Country 25');
INSERT INTO countries(id, name)
VALUES('26', 'Country 26');
INSERT INTO countries(id, name)
VALUES('27', 'Country 27');
INSERT INTO countries(id, name)
VALUES('28', 'Country 28');
INSERT INTO countries(id, name)
VALUES('29', 'Country 29');
INSERT INTO countries(id, name)
VALUES('30', 'Country 30');
-- ALTER SEQUENCE countris_id_seq RESTART WITH 4;

INSERT INTO cities(id, name, country_id)
VALUES('1', 'Hurhgada', '1');
INSERT INTO cities(id, name, country_id)
VALUES('2', 'Avsallar', '2');
INSERT INTO cities(id, name, country_id)
VALUES('3', 'Port el Cantaoui', '3');
INSERT INTO cities(id, name, country_id)
VALUES('4', 'Kemer', '2');
INSERT INTO cities(id, name, country_id)
VALUES('5', 'Marmaris', '2');
INSERT INTO cities(id, name, country_id)
VALUES('6', 'Alania', '2');
INSERT INTO cities(id, name, country_id)
VALUES('7', 'Belek', '2');
INSERT INTO cities(id, name, country_id)
VALUES('8', 'Side', '2');
INSERT INTO cities(id, name, country_id)
VALUES('9', 'City 9', '9');
INSERT INTO cities(id, name, country_id)
VALUES('10', 'City 10', '10');
INSERT INTO cities(id, name, country_id)
VALUES('11', 'City 11', '11');
INSERT INTO cities(id, name, country_id)
VALUES('12', 'City 12', '12');
INSERT INTO cities(id, name, country_id)
VALUES('13', 'City 13', '13');
INSERT INTO cities(id, name, country_id)
VALUES('14', 'City 14', '14');
INSERT INTO cities(id, name, country_id)
VALUES('15', 'City 15', '15');
INSERT INTO cities(id, name, country_id)
VALUES('16', 'City 16', '16');
INSERT INTO cities(id, name, country_id)
VALUES('17', 'City 17', '17');
INSERT INTO cities(id, name, country_id)
VALUES('18', 'City 18', '18');
INSERT INTO cities(id, name, country_id)
VALUES('19', 'City 19', '19');
INSERT INTO cities(id, name, country_id)
VALUES('20', 'City 20', '20');
INSERT INTO cities(id, name, country_id)
VALUES('21', 'City 21', '21');
INSERT INTO cities(id, name, country_id)
VALUES('22', 'City 22', '22');
INSERT INTO cities(id, name, country_id)
VALUES('23', 'City 23', '23');
INSERT INTO cities(id, name, country_id)
VALUES('24', 'City 24', '24');
INSERT INTO cities(id, name, country_id)
VALUES('25', 'City 25', '25');
INSERT INTO cities(id, name, country_id)
VALUES('26', 'City 26', '26');
INSERT INTO cities(id, name, country_id)
VALUES('27', 'City 27', '27');
INSERT INTO cities(id, name, country_id)
VALUES('28', 'City 28', '28');
INSERT INTO cities(id, name, country_id)
VALUES('29', 'City 29', '29');
INSERT INTO cities(id, name, country_id)
VALUES('30', 'City 30', '30');
-- ALTER SEQUENCE cities_id_seq RESTART WITH 9;

INSERT INTO hotels(id, name, city_id, category)
VALUES('1', 'Hurhgada hotel 1', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('2', 'Hurhgada hotel 2', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('3', 'Hurhgada hotel 3', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('4', 'Hurhgada hotel 4', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('5', 'Hurhgada hotel 5', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('6', 'Hurhgada hotel 6', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('7', 'Hurhgada hotel 7', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('8', 'Hurhgada hotel 8', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('9', 'Hurhgada hotel 9', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('10', 'Hurhgada hotel 10', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('11', 'Hurhgada hotel 11', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('12', 'Hurhgada hotel 12', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('13', 'Hurhgada hotel 13', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('14', 'Hurhgada hotel 14', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('15', 'Hurhgada hotel 15', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('16', 'Hurhgada hotel 16', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('17', 'Hurhgada hotel 17', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('18', 'Hurhgada hotel 18', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('19', 'Hurhgada hotel 19', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('20', 'Hurhgada hotel 20', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('21', 'Hurhgada hotel 21', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('22', 'Hurhgada hotel 22', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('23', 'Hurhgada hotel 23', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('24', 'Hurhgada hotel 24', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('25', 'Hurhgada hotel 25', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('26', 'Hurhgada hotel 26', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('27', 'Hurhgada hotel 27', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('28', 'Hurhgada hotel 28', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('29', 'Hurhgada hotel 29', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('30', 'Hurhgada hotel 30', '1', 'FIVE_STARS');

INSERT INTO hotels(id, name, city_id, category)
VALUES('32', 'Avsallar hotel 1', '2', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('33', 'Port el Cantaoui hotel 1', '3', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('34', 'City 4 Hotel 4', '4', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('35', 'City 5 Hotel 5', '5', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('36', 'City 6 Hotel 6', '6', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('37', 'City 7 Hotel 7', '7', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('38', 'City 8 Hotel 8', '8', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('39', 'City 9 Hotel 9', '9', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('40', 'City 10 Hotel 10', '10', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('41', 'City 11 Hotel 11', '11', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('42', 'City 12 Hotel 12', '12', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('43', 'City 13 Hotel 13', '13', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('44', 'City 14 Hotel 14', '14', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('45', 'City 15 Hotel 15', '15', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('46', 'City 16 Hotel 16', '16', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('47', 'City 17 Hotel 17', '17', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('48', 'City 18 Hotel 18', '18', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('49', 'City 19 Hotel 19', '19', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('50', 'City 20 Hotel 20', '20', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('51', 'City 21 Hotel 21', '21', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('52', 'City 22 Hotel 22', '22', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('53', 'City 23 Hotel 23', '23', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('54', 'City 24 Hotel 24', '24', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('55', 'City 25 Hotel 25', '25', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('56', 'City 26 Hotel 26', '26', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('57', 'City 27 Hotel 27', '27', 'THREE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('58', 'City 28 Hotel 28', '28', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('59', 'City 29 Hotel 29', '29', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('60', 'City 30 Hotel 30', '30', 'THREE_STARS');
-- ALTER SEQUENCE hotels_id_seq RESTART WITH 4;

INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('1', '101', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('2', '102', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('3', '103', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('4', '104', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('5', '105', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('6', '106', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('7', '107', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('8', '108', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('9', '109', '1', '3', '10000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('10', '110', '1', '3', '10000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('11', '111', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('12', '112', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('13', '113', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('14', '114', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('15', '115', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('16', '116', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('17', '117', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('18', '118', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('19', '119', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('20', '120', '1', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('21', '121', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('22', '122', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('23', '123', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('24', '124', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('25', '125', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('26', '126', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('27', '127', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('28', '128', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('29', '129', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('30', '130', '1', '1', '30000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('31', '101', '2', '1', '30000', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('32', '201', '3', '2', '20000', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('33', '301', '4', '3', '10000', '3');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('34', '302', '4', '3', '10000', '3');

INSERT INTO booking(id, room_id, user_username, total_sum, persons, check_in, check_out)
VALUES('1', '1', 'BobMarley', '30000', '1', '2018-02-25', '2018-02-28');
INSERT INTO booking(id, room_id, user_username, total_sum, persons, check_in, check_out)
VALUES('2', '2', 'JamesBond', '20000', '2', '2018-02-28', '2018-03-05');
INSERT INTO booking(id, room_id, user_username, total_sum, persons, check_in, check_out)
VALUES('3', '33', 'user1', '10000', '3', '2018-05-10', '2018-05-17');