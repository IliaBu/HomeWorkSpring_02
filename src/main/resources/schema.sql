DROP TABLE IF EXISTS userTable;
CREATE TABLE userTable
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(50) NOT NULL,
    lastName  varchar(50) NOT NULL
);

INSERT INTO userTable (firstName, lastName)
VALUES ('Иван', 'Иванов'),
       ('Сергей', 'Крапивин'),
       ('Руслан', 'Иванов');
