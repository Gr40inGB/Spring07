create table if not exists users
(
    id       bigint generated always as identity primary key,
    name     varchar(128) not null,
    password varchar(128) not null  DEFAULT '{noop}123',
    email    varchar(128) not null,
    role     varchar(128) not null

);

INSERT INTO users (name, password, email, role)
VALUES ('root', 'root', 'root@mail.ru', 'ADMIN');

INSERT INTO users (name, password, email, role)
VALUES ('user', 'user', 'user@mail.ru', 'USER');



