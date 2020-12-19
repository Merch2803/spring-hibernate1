BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO product (title, price) VALUES

('киви', 104),
('мандарин', 123),
('апельсин', 157),
('банан', 133),
('хурма', 299);

COMMIT;