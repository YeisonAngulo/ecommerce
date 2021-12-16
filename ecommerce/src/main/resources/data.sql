drop table IF EXISTS PRODUCT;
drop table IF EXISTS CART;
drop table IF EXISTS CART_DETAIL;

CREATE TABLE PRODUCT (
    ID_PRODUCT		VARCHAR(50) NOT NULL,
    TYPE_PRODUCT    VARCHAR(20) NOT NULL, --SIMPLE or DISCOUNT
    NAME			VARCHAR(100) NOT NULL,
    SKU			    VARCHAR(30) NOT NULL,
    DESCRIPTION	    VARCHAR(255) NOT NULL,
    PRICE			DOUBLE NOT NULL,
    STOCK			INT NOT NULL,
    STATUS			VARCHAR(10) NOT NULL, --ACTIVE or INACTIVE
    PRIMARY KEY(ID_PRODUCT)
);

CREATE TABLE CART (
    ID_CART		    VARCHAR(50) NOT NULL,
    TOTAL_VALUE		DOUBLE NOT NULL,
    STATUS			VARCHAR(10) NOT NULL, --OPEN or COMPLETED
    DATE_CREATED    TIMESTAMP,
    PRIMARY KEY(ID_CART)
);

CREATE TABLE CART_DETAIL (
    ID_DETAIL       VARCHAR(50) NOT NULL,
    ID_CART		    VARCHAR(50) NOT NULL,
    ID_PRODUCT		VARCHAR(50) NOT NULL,
    QUANTITY		INT NOT NULL,
    FOREIGN KEY (ID_CART) REFERENCES CART(ID_CART),
    FOREIGN KEY (ID_PRODUCT) REFERENCES PRODUCT(ID_PRODUCT),
    PRIMARY KEY(ID_DETAIL)
);

INSERT INTO PRODUCT(ID_PRODUCT, TYPE_PRODUCT, NAME, SKU, DESCRIPTION, PRICE, STOCK, STATUS) VALUES ('13d55d57-5bc7-47f4-a3c0-fe964d77db41', 'SIMPLE', 'METAL DOOR', '100123123', 'METAL DOOR DESIGNED BY YEISON', 100000.0, 10, 'ACTIVE');
INSERT INTO PRODUCT(ID_PRODUCT, TYPE_PRODUCT, NAME, SKU, DESCRIPTION, PRICE, STOCK, STATUS) VALUES ('23d55d57-5bc7-47f4-a3c0-fe964d77db41', 'DISCOUNT', 'WOOD DOOR', '100123124', 'WOOD DOOR DESIGNED BY YEISON', 110000.0, 5, 'INACTIVE');

INSERT INTO CART(ID_CART, TOTAL_VALUE, STATUS, DATE_CREATED) VALUES ('33d55d57-5bc7-47f4-a3c0-fe964d77db41', 110000.0, 'OPEN', '2021-12-15 16:50:05');

INSERT INTO CART_DETAIL(ID_DETAIL, ID_CART, ID_PRODUCT, QUANTITY) VALUES ('43d55d57-5bc7-47f4-a3c0-fe964d77db41', '33d55d57-5bc7-47f4-a3c0-fe964d77db41','23d55d57-5bc7-47f4-a3c0-fe964d77db41', 1);