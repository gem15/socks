CREATE TABLE Sock (
  ID          SERIAL NOT NULL,
  Color       varchar(255) NOT NULL,
  Cotton_Part int4 NOT NULL,
  Quantity    int4 NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT color_cotton_part
    UNIQUE (Color, Cotton_Part));

-- CREATE TABLE "Order" (
--   ID         SERIAL NOT NULL,
--   sock_id int4 NOT NULL,
--   Inout      int4 NOT NULL,
--   Quantity   int4 NOT NULL,
--   PRIMARY KEY (ID));
-- ALTER TABLE "Order" ADD CONSTRAINT FKOrder324435 FOREIGN KEY (sock_id) REFERENCES Sock (ID);
