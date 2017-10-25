INSERT INTO CUSTOMER (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, COUNTRY, ENABLED, LASTPASSWORDRESETDATE) VALUES ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', null, null, null, true, '01-01-2017');
INSERT INTO CUSTOMER (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, COUNTRY, ENABLED, LASTPASSWORDRESETDATE) VALUES ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', null, null, null, true, '01-01-2017');

INSERT INTO AUTHORITY (NAME) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (NAME) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);

INSERT INTO category(description, title) VALUES ('Description for category1', 'Category1');
INSERT INTO category(description, title) VALUES ('Description for category2', 'Category2');
INSERT INTO category(description, title) VALUES ('Description for category3', 'Category3');
INSERT INTO category(description, title) VALUES ('Description for category4', 'Category4');
INSERT INTO category(description, title) VALUES ('Description for category5', 'Category5');
INSERT INTO category(description, title) VALUES ('Description for category6', 'Category6');
INSERT INTO category(description, title) VALUES ('Description for category7', 'Category7');
INSERT INTO category(description, title) VALUES ('Description for category8', 'Category8');
INSERT INTO category(description, title) VALUES ('Description for category9', 'Category9');
INSERT INTO category(description, title) VALUES ('Description for category10', 'Category10');

INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer1', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer2', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer3', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer4', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer5', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer5', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer4', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer3', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer2', 2017);
INSERT INTO product_details(country_of_origin, expiry_date, image, manufacturer, production_year)
    VALUES ('Serbia', '12-31-2017', 'http://imalures.com/wp-content/uploads/2015/01/127880648.jpg', 'Manufacturer1', 2017);    

INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product1', 10, 100.00, 1, 1);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product2', 10, 50.00, 2, 2);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product3', 10, 1000.00, 3, 3);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product4', 10, 370.00, 4, 4);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product5', 10, 120.00, 5, 5);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product6', 10, 200.00, 6, 6);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product7', 10, 60.00, 7, 7);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product8', 10, 845.00, 8, 8);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product9', 10, 620.00, 9, 9);
INSERT INTO product(name, stock, price, category_id, details_id)
	VALUES ('Product10', 10, 550.00, 10, 10);
	