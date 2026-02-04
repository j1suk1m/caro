-- Member table
CREATE TABLE IF NOT EXISTS member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at DATETIME(6) NOT NULL
);

-- Car Brand table
CREATE TABLE IF NOT EXISTS car_brand (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Car Model table
CREATE TABLE IF NOT EXISTS car_model (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    variant VARCHAR(255) NOT NULL,
    start_year INT NOT NULL,
    end_year INT,
    FOREIGN KEY (brand_id) REFERENCES car_brand(id)
);

-- Member Car table
CREATE TABLE IF NOT EXISTS member_car (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    model_id BIGINT NOT NULL,
    registration_number VARCHAR(255) NOT NULL,
    mileage INT NOT NULL,
    created_at DATETIME(6) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id),
    FOREIGN KEY (model_id) REFERENCES car_model(id)
);
