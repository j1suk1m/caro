CREATE TABLE member_coupon (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    reward_coupon_id BIGINT NOT NULL,
    used_points INT NOT NULL,
    barcode_number VARCHAR(13) NOT NULL UNIQUE,
    used_at DATETIME(6) NULL,
    expired_at DATETIME(6) NOT NULL,
    created_at DATETIME(6) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id),
    FOREIGN KEY (reward_coupon_id) REFERENCES reward_coupon(id)
);
