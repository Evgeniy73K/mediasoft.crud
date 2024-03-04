CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS category
(
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    category    VARCHAR(255),
    created_at  DATE             DEFAULT CURRENT_DATE,
    modified_at DATE             DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS products
(
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name        VARCHAR(255),
    article     VARCHAR(255),
    dictionary  VARCHAR(255),
    category_id UUID,
    price       NUMERIC,
    qty         NUMERIC,
    created_at  DATE             DEFAULT CURRENT_DATE,
    modified_at DATE             DEFAULT CURRENT_DATE,
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE
);

INSERT INTO category (id, category)
VALUES ('63a66ab6-4b12-4950-9f82-9ab566dbcc75', 'Test category');

INSERT INTO products (id, name, article, dictionary, category_id, price, qty, created_at, modified_at)
VALUES (uuid_generate_v4(), 'Sample Product', 'ABC123', 'Sample Description',
        (SELECT id FROM category ORDER BY id LIMIT 1), 99.99, 10,
        CURRENT_DATE, CURRENT_DATE);