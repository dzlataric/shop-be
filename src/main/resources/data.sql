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