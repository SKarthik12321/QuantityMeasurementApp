CREATE TABLE IF NOT EXISTS quantity_measurement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    value DOUBLE,
    unit VARCHAR(50),
    operation VARCHAR(50),
    result DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
