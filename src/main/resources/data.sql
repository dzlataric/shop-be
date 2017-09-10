INSERT INTO CUSTOMER (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, COUNTRY, ENABLED, LASTPASSWORDRESETDATE) VALUES ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', null, null, null, true, '01-01-2017');
INSERT INTO CUSTOMER (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, COUNTRY, ENABLED, LASTPASSWORDRESETDATE) VALUES ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', null, null, null, true, '01-01-2017');

INSERT INTO AUTHORITY (NAME) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (NAME) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);

INSERT INTO category(description, title) VALUES ('Čajevi', 'Čajevi');
INSERT INTO category(description, title) VALUES ('Imunitet', 'Imunitet');
INSERT INTO category(description, title) VALUES ('Mršavljenje', 'Mršavljenje');
INSERT INTO category(description, title) VALUES ('Aparati', 'Aparati');
INSERT INTO category(description, title) VALUES ('Kozmetika', 'Kozmetika');
INSERT INTO category(description, title) VALUES ('Hrana', 'Hrana');
INSERT INTO category(description, title) VALUES ('Čajevi', 'Čajevi');
INSERT INTO category(description, title) VALUES ('Imunitet', 'Imunitet');
INSERT INTO category(description, title) VALUES ('Mršavljenje', 'Mršavljenje');
INSERT INTO category(description, title) VALUES ('Aparati', 'Aparati');
INSERT INTO category(description, title) VALUES ('Kozmetika', 'Kozmetika');
INSERT INTO category(description, title) VALUES ('Hrana', 'Hrana');

INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', null, 'Random', 2017);

INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product', 12, 100.00, 1, 1);