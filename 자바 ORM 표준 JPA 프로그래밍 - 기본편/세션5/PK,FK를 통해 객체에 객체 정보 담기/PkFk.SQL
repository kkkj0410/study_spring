CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
);

CREATE TABLE orders (
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
