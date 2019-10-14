INSERT INTO user_role Values(1, 'ADMIN');
INSERT INTO user_role Values(2, 'DEV');
INSERT INTO user_role Values(3, 'REG');
INSERT INTO user_role Values(4, 'LOCKED');


INSERT INTO training_type Values(1, 'JAVA');
INSERT INTO training_type Values(2, 'DEVOPS');
INSERT INTO training_type Values(3, 'C#');
INSERT INTO training_type Values(4, 'ANGULAR');




INSERT INTO users (id, email, firstName, lastName, username, password) VALUES (1,'nwilliams@gmail.com','Nigel','Williams', 'nwilliams', 'p4ssw0rd', 1);
INSERT INTO users (id, email, firstName, lastName, username, password) VALUES (3, 'snavy@yahoo.com','Shantoy','Navy','snavy', 'p2ssw0rd', 2);
INSERT INTO users (id, email, firstName, lastName, username, password) VALUES (4, 'adesiel@gmail.com', 'Allure',  'Desiel', 'adesiel', 'p3ssw0rd', 3);
INSERT INTO users (id, email, firstName, lastName, username, password) VALUES (5,'jnotchan@outlook.com','Jackie', 'Notchan', 'jnotchan', 'p0ssw0rd', 4);


INSERT INTO USER_PROFILE VALUES (1, 'HELP ME NOT', 1, 1);
INSERT INTO USER_PROFILE VALUES (2, 'HELP ME NOT', 5, 2);
INSERT INTO USER_PROFILE VALUES (3, 'HELP ME NOT', 2, 3);
INSERT INTO USER_PROFILE VALUES (4, 'HELP ME NOT', 4, 4);
INSERT INTO USER_PROFILE VALUES (5, 'HELP ME NOT', 3, 

INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode) VALUES (1, 'Tampa', NULL, NULL, 'FL', '231 Rose Street', 11400);
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode)  VALUES (2, 'Tampa', NULL, NULL, 'FL', '232 Grape Street', 11401);
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode)  VALUES (3, 'Tampa', NULL, NULL, 'FL', '233 Orange Street', 11402);
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode)  VALUES (4, 'Tampa', NULL, NULL, 'FL', '234 Mango Street', 11403);
INSERT INTO ADDRESS (id, city, lattitude, longitude, state, street address, zipcode)  VALUES (5, 'Tampa', NULL, NULL, 'FL', '235 Apple Street', 11404);


INSERT INTO HOUSING VALUES (1, 'Anything', 800.00, 1, 1);
INSERT INTO HOUSING VALUES (2, 'Anything', 900.00, 2, 2);
INSERT INTO HOUSING VALUES (3, 'Anything', 1000.00, 3, 3);
INSERT INTO HOUSING VALUES (4, 'Anything', 1100.00, 4, 4);
INSERT INTO HOUSING VALUES (5, 'Anything', 1200.00, 5, 5);

INSERT INTO ROOM_FOR_RENT VALUES (1, 300, 1);
INSERT INTO ROOM_FOR_RENT VALUES (2, 400, 2);
INSERT INTO ROOM_FOR_RENT VALUES (3, 500, 3);
INSERT INTO ROOM_FOR_RENT VALUES (4, 600, 4);
INSERT INTO ROOM_FOR_RENT VALUES (5, 700, 5);
