INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME) Values(1, 'ADMIN');
INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME) Values(2, 'DEV');
INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME) Values(3, 'REG');
INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME) Values(4, 'LOCKED');


INSERT INTO training_type (TRAINING_ID, TRAINING_TYPE) Values(1, 'JAVA');
INSERT INTO training_type (TRAINING_ID, TRAINING_TYPE) Values(2, 'DEVOPS');
INSERT INTO training_type (TRAINING_ID, TRAINING_TYPE) Values(3, 'C#');
INSERT INTO training_type (TRAINING_ID, TRAINING_TYPE) Values(4, 'ANGULAR');




<<<<<<< HEAD
INSERT INTO users (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, USER_ROLE_FK) VALUES (1,'nwilliams@gmail.com','Nigel','Williams', 'nwilliams', 'p4ssw0rd', 1);
INSERT INTO users (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, USER_ROLE_FK) VALUES (3, 'snavy@yahoo.com','Shantoy','Navy','snavy', 'p2ssw0rd', 2);
INSERT INTO users (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, USER_ROLE_FK) VALUES (4, 'adesiel@gmail.com', 'Allure',  'Desiel', 'adesiel', 'p3ssw0rd', 3);
INSERT INTO users (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, USER_ROLE_FK) VALUES (5,'jnotchan@outlook.com','Jackie', 'Notchan', 'jnotchan', 'p0ssw0rd', 4);
=======
INSERT INTO users (id, email, firstName, lastName, username, password) VALUES (1,'nwilliams@gmail.com','Nigel','Williams', 'nwilliams', 'p4ssw0rd', 1);
INSERT INTO users (id, email, firstName, lastName, username, password) VALUES (3, 'snavy@yahoo.com','Shantoy','Navy','snavy', 'p2ssw0rd', 2);
INSERT INTO users (id, email, firstName, lastName, username, password) VALUES (4, 'adesiel@gmail.com', 'Allure',  'Desiel', 'adesiel', 'p3ssw0rd', 3);
INSERT INTO users (id, email, firstName, lastName, username, password) VALUES (5,'jnotchan@outlook.com','Jackie', 'Notchan', 'jnotchan', 'p0ssw0rd', 4);
>>>>>>> 86688c60e63575a1c10a0ec92bfe783662ba612c


INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (1, 'HELP ME NOT', 1, 1);
INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (2, 'HELP ME NOT', 5, 2);
INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (3, 'HELP ME NOT', 2, 3);
INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (4, 'HELP ME NOT', 4, 4);
INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (5, 'HELP ME NOT', 3, 

<<<<<<< HEAD
INSERT INTO ADDRESS (ADDRESS_ID, CITY, LATITUDE, LONGITUDE, STATE, STREET_ADDRESS, ZIP_CODE) VALUES (1, 'Tampa', NULL, NULL, 'FL', 231, 'Rose Street', 11400);
INSERT INTO ADDRESS (ADDRESS_ID, CITY, LATITUDE, LONGITUDE, STATE, STREET_ADDRESS, ZIP_CODE) VALUES (2, 'Tampa', NULL, NULL, 'FL', 232, 'Grape Street', 11401);
INSERT INTO ADDRESS (ADDRESS_ID, CITY, LATITUDE, LONGITUDE, STATE, STREET_ADDRESS, ZIP_CODE) VALUES (3, 'Tampa', NULL, NULL, 'FL', 233, 'Orange Street', 11402);
INSERT INTO ADDRESS (ADDRESS_ID, CITY, LATITUDE, LONGITUDE, STATE, STREET_ADDRESS, ZIP_CODE) VALUES (4, 'Tampa', NULL, NULL, 'FL', 234, 'Mango Street', 11403);
INSERT INTO ADDRESS (ADDRESS_ID, CITY, LATITUDE, LONGITUDE, STATE, STREET_ADDRESS, ZIP_CODE) VALUES (5, 'Tampa', NULL, NULL, 'FL', 235, 'Apple Street', 11404);
=======
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode) VALUES (1, 'Tampa', NULL, NULL, 'FL', '231 Rose Street', 11400);
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode)  VALUES (2, 'Tampa', NULL, NULL, 'FL', '232 Grape Street', 11401);
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode)  VALUES (3, 'Tampa', NULL, NULL, 'FL', '233 Orange Street', 11402);
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode)  VALUES (4, 'Tampa', NULL, NULL, 'FL', '234 Mango Street', 11403);
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode)  VALUES (5, 'Tampa', NULL, NULL, 'FL', '235 Apple Street', 11404);
>>>>>>> 86688c60e63575a1c10a0ec92bfe783662ba612c


INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (1, 'Anything', 800.00, 1, 1);
INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (2, 'Anything', 900.00, 2, 2);
INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (3, 'Anything', 1000.00, 3, 3);
INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (4, 'Anything', 1100.00, 4, 4);
INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (5, 'Anything', 1200.00, 5, 5);

<<<<<<< HEAD
INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (1, 300, 1);
INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (2, 400, 2);
INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (3, 500, 3);
INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (4, 600, 4);
INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (5, 700, 5);
=======
INSERT INTO ROOM_FOR_RENT VALUES (1, 300, 1);
INSERT INTO ROOM_FOR_RENT VALUES (2, 400, 2);
INSERT INTO ROOM_FOR_RENT VALUES (3, 500, 3);
INSERT INTO ROOM_FOR_RENT VALUES (4, 600, 4);
INSERT INTO ROOM_FOR_RENT VALUES (5, 700, 5);
>>>>>>> 86688c60e63575a1c10a0ec92bfe783662ba612c
