DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(30),
    emailAddress VARCHAR(30),
    title VARCHAR(30)
);