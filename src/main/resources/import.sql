INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME) Values(1, 'ADMIN');
INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME) Values(2, 'DEV');
INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME) Values(3, 'REG');
INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME) Values(4, 'LOCKED');


INSERT INTO training_type (TRAINING_ID, TRAINING_TYPE) Values(1, 'JAVA');
INSERT INTO training_type (TRAINING_ID, TRAINING_TYPE) Values(2, 'DEVOPS');
INSERT INTO training_type (TRAINING_ID, TRAINING_TYPE) Values(3, 'C#');
INSERT INTO training_type (TRAINING_ID, TRAINING_TYPE) Values(4, 'ANGULAR');


INSERT INTO users (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES (1,'test@example.com','Nigel','Williams', 'p4ssw0rd', 'example', 1);
INSERT INTO users (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES (3, 'snavy@yahoo.com','Shantoy','Navy','snavy', 'p2ssw0rd', 2);
INSERT INTO users (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES (4, 'adesiel@gmail.com', 'Allure',  'Desiel', 'adesiel', 'p3ssw0rd', 3);
INSERT INTO users (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES (5,'jnotchan@outlook.com','Jackie', 'Notchan', 'jnotchan', 'p0ssw0rd', 4);


INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (1, 'HELP ME NOT', 1, 1);
INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (2, 'HELP ME NOT', 5, 2);
INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (3, 'HELP ME NOT', 2, 3);
INSERT INTO USER_PROFILE (ID, DESCRIPTION, TRAINING_TYPE_FK, USER_USER_ID) VALUES (4, 'HELP ME NOT', 4, 4);


INSERT INTO ADDRESS (ADDRESS_ID, city, lattitude, longitude, state, STREET_ADDRESS, ZIP_CODE) VALUES (1, 'Tampa', NULL, NULL, 'FL', '231 Rose Street', 11400);
INSERT INTO ADDRESS (ADDRESS_ID, city, lattitude, longitude, state, STREET_ADDRESS, ZIP_CODE) VALUES (2, 'Tampa', NULL, NULL, 'FL', '232 Grape Street', 11401);
INSERT INTO ADDRESS (ADDRESS_ID, city, lattitude, longitude, state, STREET_ADDRESS, ZIP_CODE) VALUES (3, 'Tampa', NULL, NULL, 'FL', '233 Orange Street', 11402);
INSERT INTO ADDRESS (ADDRESS_ID, city, lattitude, longitude, state, STREET_ADDRESS, ZIP_CODE) VALUES (4, 'Tampa', NULL, NULL, 'FL', '234 Mango Street', 11403);


INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (1, 'Anything', 800.00, 1, 1);
INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (2, 'Anything', 900.00, 2, 2);
INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (3, 'Anything', 1000.00, 3, 3);
INSERT INTO HOUSING (HOUSING_ID, DESCRIPTION, PRICE_PER_MONTH, ADDRESS_ADDRESS_ID, USER_FK) VALUES (4, 'Anything', 1100.00, 4, 4);


INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (1, 300, 1);
INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (2, 400, 2);
INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (3, 500, 3);
INSERT INTO ROOM_FOR_RENT (ROOM_FOR_RENT_ID, PRICE_PER_MONTH, HOUSING_FK) VALUES (4, 600, 4);
