CREATE TABLE STOCK_HISTORY (
    `symbol` CHAR(5),
    `afterHours` NUMERIC,
    `close` NUMERIC,
    `fromDate` VARCHAR(25),
    `high` NUMERIC,
    `low` NUMERIC,
    `open` NUMERIC,
    `preMarket` NUMERIC,
    `status` VARCHAR(50),
    `volume` INTEGER);


CREATE TABLE USER_STOCK (
    `symbol` CHAR(5),
    `username` VARCHAR(50),
    `dateAdded` VARCHAR(30));

CREATE TABLE USER_TABLE (
    `name` VARCHAR(100),
    `username` VARCHAR(100),
    `passwd` VARCHAR(100));

ALTER TABLE USER_STOCK
    ADD CONSTRAINT `user_stock_fk` FOREIGN KEY (`username`) REFERENCES USER_TABLE(`username`)
        ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE USER_STOCK
    ADD CONSTRAINT `stock_user_fk` FOREIGN KEY (`username`) REFERENCES `STOCK_HISTORY`(`symbol`)
        ON DELETE CASCADE ON UPDATE CASCADE;