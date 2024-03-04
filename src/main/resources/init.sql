CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS category (
                                        id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                                        category VARCHAR(255),
                                        created_at DATE DEFAULT CURRENT_DATE,
                                        modified_at DATE DEFAULT CURRENT_DATE
);

INSERT INTO category (category)
VALUES ('Test category');

CREATE TABLE IF NOT EXISTS products (
                                        id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255),
    article VARCHAR(255),
    dictionary VARCHAR(255),
    category_id UUID,
    price NUMERIC,
    qty NUMERIC,
    created_at DATE DEFAULT CURRENT_DATE,
    modified_at DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
    );


INSERT INTO products (name, article, dictionary, category_id, price, qty, created_at, modified_at)
VALUES (
           'Sample Product',
           'ABC123',
           'Sample Description',
           (SELECT id FROM category ORDER BY id LIMIT 1),
    99.99,
    10,
            CURRENT_DATE,
            CURRENT_DATE
    );