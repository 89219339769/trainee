
CREATE TABLE IF NOT EXISTS films (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(512) NOT NULL,
    director VARCHAR(100),
    budget Integer,
    CONSTRAINT film PRIMARY KEY (id),
    CONSTRAINT name UNIQUE (name)
    );

DELETE FROM FILMS;
ALTER TABLE FILMS ALTER COLUMN ID RESTART WITH 1;


CREATE TABLE IF NOT EXISTS users (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    email VARCHAR(512) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    nickName VARCHAR(255) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT email UNIQUE (email)
    );
--
-- --DELETE FROM users;
-- --ALTER TABLE users ALTER COLUMN ID RESTART WITH 1;
--
--
--
--
CREATE TABLE IF NOT EXISTS rates (
                                     id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,


    CONSTRAINT rate_pk PRIMARY KEY (id),
    author_id bigint        not null
    references users
    on delete cascade,

    film_id   bigint        not null
    references films
    on delete cascade,

    rate Integer

    );

--DELETE FROM rates;
--ALTER TABLE rates ALTER COLUMN ID RESTART WITH 1;