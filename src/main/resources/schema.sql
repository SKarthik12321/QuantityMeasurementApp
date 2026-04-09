CREATE TABLE IF NOT EXISTS quantity_measurement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    val DOUBLE,
    unit VARCHAR(50),
    operation VARCHAR(50),
    result DOUBLE
);