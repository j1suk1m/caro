CREATE TABLE IF NOT EXISTS reward_brand (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    created_at DATETIME(6) NOT NULL
);

CREATE TABLE IF NOT EXISTS reward_coupon (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    reward_brand_id BIGINT NOT NULL,
    item_name VARCHAR(255) NOT NULL,
    required_points INT NOT NULL,
    image_url VARCHAR(500),
    redeem_count INT NOT NULL DEFAULT 0,
    created_at DATETIME(6) NOT NULL,
    FOREIGN KEY (reward_brand_id) REFERENCES reward_brand(id)
);
