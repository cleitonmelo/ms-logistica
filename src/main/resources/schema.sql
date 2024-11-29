CREATE TABLE IF NOT EXISTS CARRIERS(
    code BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    zip_code_start Integer,
    zip_code_end Integer,
    delivery_limit_days Integer Default 2
);