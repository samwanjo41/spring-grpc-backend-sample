CREATE TABLE stock (
    id BIGSERIAL PRIMARY KEY,
    stock_symbol VARCHAR(255) NOT NULL UNIQUE,
    price DOUBLE PRECISION,
    last_updated TIMESTAMP
);


INSERT INTO stock (stock_symbol, price, last_updated) VALUES
('AAPL', 189.25, NOW()),
('GOOGL', 2751.32, NOW()),
('MSFT', 412.11, NOW()),
('AMZN', 134.85, NOW()),
('TSLA', 724.52, NOW()),
('NFLX', 455.90, NOW()),
('META', 379.40, NOW()),
('NVDA', 1234.56, NOW()),
('BABA', 89.67, NOW()),
('ORCL', 117.10, NOW());