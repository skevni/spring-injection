drop table if exists public.orders;
drop table if exists public.customers;
drop table if exists public.products;

CREATE TABLE public.customers (
    id bigserial NOT NULL,
    "name" varchar(255) NULL,
    CONSTRAINT customers_pkey PRIMARY KEY (id)
);

CREATE TABLE public.products (
    id bigserial NOT NULL,
    "cost" float8 NULL,
    title varchar(255) NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id)
);

CREATE TABLE public.orders (
    id bigserial NOT NULL,
    "cost" float8 NULL,
    customer_id int8 NULL,
    product_id int8 NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id)
);

-- public.orders foreign keys
ALTER TABLE public.orders ADD CONSTRAINT fkkp5k52qtiygd8jkag4hayd0qg FOREIGN KEY (product_id) REFERENCES public.products(id);
ALTER TABLE public.orders ADD CONSTRAINT fkpxtb8awmi0dk6smoh2vp1litg FOREIGN KEY (customer_id) REFERENCES public.customers(id);

-- fill the tables
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
