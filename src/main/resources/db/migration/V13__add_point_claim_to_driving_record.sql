ALTER TABLE driving_record
    ADD COLUMN pending_points INT NOT NULL DEFAULT 0,
    ADD COLUMN points_claimed TINYINT(1) NOT NULL DEFAULT 0;

-- 기존 데이터 마이그레이션: 이미 부여된 포인트는 수령 완료로 처리
UPDATE driving_record SET pending_points = earned_points, points_claimed = 1;
