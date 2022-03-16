CREATE DATABASE test;

CREATE TABLE Sock
(
    ID          SERIAL       NOT NULL,
    Color       varchar(255) NOT NULL,
    Cotton_Part int4         NOT NULL,
    Quantity    int4         NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT color_cotton_part
        UNIQUE (Color, Cotton_Part)
);

-- тестовые данные
INSERT INTO public.sock (color, cotton_part, quantity)
values ('red', 18, 1),
       ('red', 30, 2),
       ('red', 42, 3),
       ('black', 18, 4),
       ('black', 30, 5),
       ('black', 42, 6)
;
