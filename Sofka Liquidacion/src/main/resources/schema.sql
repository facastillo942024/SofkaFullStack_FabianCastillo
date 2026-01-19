CREATE TABLE IF NOT EXISTS transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    type VARCHAR(20) NOT NULL,
    commission DOUBLE,
    transaction_date TIMESTAMP NOT NULL
);