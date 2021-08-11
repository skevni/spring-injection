INSERT INTO products(title, cost)
VALUES ('Shoes', 30.89),
       ('Shirt', 12.99),
       ('Jacket', 100.78),
       ('Coat', 150.99),
       ('Hat', 42.78);

INSERT INTO customers(name)
VALUES ('John'),
       ('Max'),
       ('Greta'),
       ('Peta'),
       ('Petr');
INSERT INTO orders(customer_id, product_id)
VALUES (1, 4),
       (1, 1),
       (3, 2),
       (3, 3),
       (5, 3),
       (5, 4),
       (2, 5),
       (2, 1),
       (2, 3),
       (4, 5);
