INSERT INTO country_weight_pricing(id, country, price, min_weight_inclusive, max_weight_exclusive)
values (1, 'USA', 10.0, 0.0, 5.0)
ON CONFLICT DO NOTHING;
INSERT INTO country_weight_pricing(id, country, price, min_weight_inclusive, max_weight_exclusive)
values (2, 'USA', 15.0, 5.0, 10.0)
ON CONFLICT DO NOTHING;
INSERT INTO country_weight_pricing(id, country, price, min_weight_inclusive, max_weight_exclusive)
values (3, 'USA', 20.0, 10.0, 15.0)
ON CONFLICT DO NOTHING;
INSERT INTO country_weight_pricing(id, country, price, min_weight_inclusive, max_weight_exclusive)
values (4, 'UK', 8.0, 0.0, 6.0)
ON CONFLICT DO NOTHING;
INSERT INTO country_weight_pricing(id, country, price, min_weight_inclusive, max_weight_exclusive)
values (5, 'UK', 10.0, 6.0, 12.0)
ON CONFLICT DO NOTHING;
INSERT INTO country_weight_pricing(id, country, price, min_weight_inclusive, max_weight_exclusive)
values (6, 'UK', 10.0, 12.0, 18.0)
ON CONFLICT DO NOTHING;

--

INSERT INTO product_code_surcharge(id, code, surcharge)
values (1, '1', 5.0)
ON CONFLICT DO NOTHING;
INSERT INTO product_code_surcharge(id, code, surcharge)
values (2, '2', 5.0)
ON CONFLICT DO NOTHING;
INSERT INTO product_code_surcharge(id, code, surcharge)
values (3, '3', 5.0)
ON CONFLICT DO NOTHING;
INSERT INTO product_code_surcharge(id, code, surcharge)
values (4, '4', 6)
ON CONFLICT DO NOTHING;
INSERT INTO product_code_surcharge(id, code, surcharge)
values (5, '5', 6)
ON CONFLICT DO NOTHING;
INSERT INTO product_code_surcharge(id, code, surcharge)
values (6, '6', 6)
ON CONFLICT DO NOTHING;
--
insert into delivery_pricing(delivery_type, name, period, price)
VALUES ('EXPRESS', 'Express Delivery', '5-7 Days', 200)
ON CONFLICT DO NOTHING;

insert into delivery_pricing(delivery_type, name, period, price)
VALUES ('NORMAL', 'Normal Delivery', '10-14 Days', 0)
ON CONFLICT DO NOTHING;
