-- DROP TABLE databasechangelog;
-- DROP TABLE databasechangeloglock;
-- DROP TABLE user_role;
-- DROP TABLE roles;
-- DROP TABLE comments;
-- DROP TABLE advertisements;
-- DROP TABLE users;
-- DROP TABLE categories;
-- DROP TABLE currencies;

INSERT INTO users(username, password, first_name, last_name, email,
                  phone_number, active, registration_date)
VALUES ('Creseliana', '$2a$10$q7O/G9/u/1WWJd4cbBKSFuPVc8X1bjRHIsxWTCioh.6VB9HY2LLC.',
        'Valeria', 'Sterzhanova', 'v.sterzhanova@yandex.ru', '375290000000', true,
        '2022-02-02 02:31:51');

INSERT INTO users(username, password, first_name, last_name, email,
                  phone_number, active, registration_date)
VALUES ('test-user-1', '$2a$10$q7O/G9/u/1WWJd4cbBKSFuPVc8X1bjRHIsxWTCioh.6VB9HY2LLC.',
        'test-name-1', 'test-name-1', 'test1@test.com', '375290000001', true,
        '2021-10-15T21:31:51');

INSERT INTO users(username, password, first_name, last_name, email,
                  phone_number, active, registration_date)
VALUES ('test-user-2', '$2a$10$q7O/G9/u/1WWJd4cbBKSFuPVc8X1bjRHIsxWTCioh.6VB9HY2LLC.',
        'test-name-2', 'test-name-2', 'test2@test.com', '375290000002', true,
        '2022-01-03T00:55:20');

INSERT INTO users(username, password, first_name, last_name, email,
                  phone_number, active, registration_date)
VALUES ('test-user-3', '$2a$10$q7O/G9/u/1WWJd4cbBKSFuPVc8X1bjRHIsxWTCioh.6VB9HY2LLC.',
        'test-name-3', 'test-name-3', 'test3@test.com', '375290000003', true,
        '2021-12-12T22:01:42');

INSERT INTO users(username, password, first_name, last_name, email,
                  phone_number, active, registration_date)
VALUES ('test-user-4', '$2a$10$q7O/G9/u/1WWJd4cbBKSFuPVc8X1bjRHIsxWTCioh.6VB9HY2LLC.',
        'test-name-4', 'test-name-4', 'test4@test.com', '375290000004', true,
        '2022-02-13T09:44:17');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1);

INSERT INTO currencies(code, quantum)
VALUES ('RUR', 0.01),
       ('USD', 0.01),
       ('EUR', 0.01),
       ('BYN', 0.01);

INSERT INTO categories(name)
VALUES ('Одежда'),
       ('Обувь'),
       ('Косметика'),
       ('Книги'),
       ('Электроника');

INSERT INTO advertisements(created_by, category_id, title, description, price,
                           currency_id, creation_date, closed, deleted)
VALUES ('test-user-1', 1, 'test-ad-1', 'd-ad-1', 300, 1, '2022-02-01T11:00:00', false, false),
       ('test-user-1', 2, 'test-ad-2', 'd-ad-2', 460, 1, '2022-02-01T12:00:00', true, false),
       ('test-user-1', 3, 'test-ad-3', 'd-ad-3', 200, 1, '2022-02-01T13:00:00', false, false),
       ('test-user-1', 3, 'test-ad-4', 'd-ad-4', 500, 1, '2022-02-01T14:00:00', true, false),
       ('test-user-2', 5, 'test-ad-5', 'd-ad-5', 44.95, 3, '2022-01-20T20:05:00', false, false),
       ('test-user-2', 5, 'test-ad-6', 'd-ad-6', 51.55, 3, '2022-01-20T20:05:00', false, false);

INSERT INTO comments(ad_id, created_by, creation_date, comment)
VALUES (1, 'test-user-3', '2022-02-01T12:00:00', 'test comment 1 to the ad 1'),
       (1, 'test-user-4', '2022-02-01T12:05:00', 'test comment 2 to the ad 1'),
       (5, 'test-user-4', '2022-02-01T12:15:00', 'test comment 3 to the ad 5');