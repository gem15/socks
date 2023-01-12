CREATE TABLE Sock (
  ID          SERIAL NOT NULL,
  Ver         int4,
  created_date date,
  Color       varchar(255) NOT NULL,
  Cotton_Part int4 NOT NULL,
  Quantity    int4 NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT color_cotton_part
    UNIQUE (Color, Cotton_Part));

CREATE TABLE mov (
  ID            SERIAL NOT NULL,
  Ver           int4,
  created_date  date,
  Sock_id       int4 NOT NULL,
  Quantity      int4 NOT NULL,
  PRIMARY KEY (ID));
ALTER TABLE mov ADD CONSTRAINT FKOrder324435 FOREIGN KEY (Sock_id) REFERENCES Sock (ID);
