-- Car Brands (14개)
INSERT INTO car_brand (id, name) VALUES (1, '현대');
INSERT INTO car_brand (id, name) VALUES (2, '기아');
INSERT INTO car_brand (id, name) VALUES (3, '제네시스');
INSERT INTO car_brand (id, name) VALUES (4, '쉐보레');
INSERT INTO car_brand (id, name) VALUES (5, '르노코리아');
INSERT INTO car_brand (id, name) VALUES (6, 'KG모빌리티');
INSERT INTO car_brand (id, name) VALUES (7, 'BMW');
INSERT INTO car_brand (id, name) VALUES (8, '벤츠');
INSERT INTO car_brand (id, name) VALUES (9, '아우디');
INSERT INTO car_brand (id, name) VALUES (10, '폭스바겐');
INSERT INTO car_brand (id, name) VALUES (11, '토요타');
INSERT INTO car_brand (id, name) VALUES (12, '혼다');
INSERT INTO car_brand (id, name) VALUES (13, '볼보');
INSERT INTO car_brand (id, name) VALUES (14, '테슬라');

-- 현대 (brand_id = 1)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (1, 1, '아반떼', 'CN7', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (2, 1, '쏘나타', 'DN8', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (3, 1, '그랜저', 'GN7', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (4, 1, '투싼', 'NX4', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (5, 1, '싼타페', 'MX5', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (6, 1, '팰리세이드', 'LX2', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (7, 1, '코나', 'SX2', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (8, 1, '아이오닉 5', 'NE', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (9, 1, '아이오닉 6', 'CE', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (10, 1, '스타리아', 'US4', 2021, NULL);

-- 기아 (brand_id = 2)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (11, 2, 'K3', 'BD', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (12, 2, 'K5', 'DL3', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (13, 2, 'K8', 'GL3', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (14, 2, 'K9', 'RJ', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (15, 2, '스포티지', 'NQ5', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (16, 2, '쏘렌토', 'MQ4', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (17, 2, '카니발', 'KA4', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (18, 2, '셀토스', 'SP2', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (19, 2, 'EV6', 'CV', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (20, 2, 'EV9', 'MV', 2023, NULL);

-- 제네시스 (brand_id = 3)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (21, 3, 'G70', 'IK', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (22, 3, 'G80', 'RG3', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (23, 3, 'G90', 'RS4', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (24, 3, 'GV60', 'JW', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (25, 3, 'GV70', 'JK1', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (26, 3, 'GV80', 'JX1', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (27, 3, 'G70 슈팅브레이크', 'IK', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (28, 3, 'GV80 쿠페', 'JX1C', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (29, 3, 'G80 전동화', 'RG3e', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (30, 3, 'GV70 전동화', 'JK1e', 2022, NULL);

-- 쉐보레 (brand_id = 4)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (31, 4, '트랙스', 'TC', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (32, 4, '트레일블레이저', 'RS', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (33, 4, '이쿼녹스', 'EQ', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (34, 4, '콜로라도', 'CC', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (35, 4, '타호', 'TH', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (36, 4, '볼트 EUV', 'EUV', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (37, 4, '볼트 EV', 'EV', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (38, 4, '말리부', 'ML', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (39, 4, '스파크', 'SP', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (40, 4, '카마로', 'CM', 2019, NULL);

-- 르노코리아 (brand_id = 5)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (41, 5, 'SM6', 'LM', 2016, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (42, 5, 'XM3', 'HM', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (43, 5, 'QM6', 'RM', 2016, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (44, 5, '그랑 콜레오스', 'GC', 2024, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (45, 5, '아르카나', 'AR', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (46, 5, '캡처', 'CP', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (47, 5, '클리오', 'CL', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (48, 5, '메간', 'MG', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (49, 5, '조에', 'ZE', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (50, 5, '트위지', 'TW', 2019, NULL);

-- KG모빌리티 (brand_id = 6)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (51, 6, '토레스', 'KR10', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (52, 6, '티볼리', 'XK', 2015, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (53, 6, '코란도', 'CK', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (54, 6, '렉스턴', 'RK', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (55, 6, '액티언', 'XA', 2024, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (56, 6, '토레스 EVX', 'KR10E', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (57, 6, '렉스턴 스포츠', 'RKS', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (58, 6, '렉스턴 스포츠 칸', 'RKK', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (59, 6, '코란도 이모션', 'CKE', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (60, 6, '티볼리 에어', 'XKA', 2016, NULL);

-- BMW (brand_id = 7)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (61, 7, '3시리즈', 'G20', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (62, 7, '5시리즈', 'G60', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (63, 7, '7시리즈', 'G70', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (64, 7, 'X3', 'G01', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (65, 7, 'X5', 'G05', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (66, 7, 'X7', 'G07', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (67, 7, 'i4', 'G26', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (68, 7, 'iX', 'I20', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (69, 7, '4시리즈 그란쿠페', 'G26', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (70, 7, 'M3', 'G80', 2020, NULL);

-- 벤츠 (brand_id = 8)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (71, 8, 'C클래스', 'W206', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (72, 8, 'E클래스', 'W214', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (73, 8, 'S클래스', 'W223', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (74, 8, 'GLC', 'X254', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (75, 8, 'GLE', 'V167', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (76, 8, 'GLS', 'X167', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (77, 8, 'EQE', 'V295', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (78, 8, 'EQS', 'V297', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (79, 8, 'A클래스', 'W177', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (80, 8, 'CLA', 'C118', 2019, NULL);

-- 아우디 (brand_id = 9)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (81, 9, 'A4', 'B9', 2016, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (82, 9, 'A6', 'C8', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (83, 9, 'A8', 'D5', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (84, 9, 'Q3', 'F3', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (85, 9, 'Q5', 'FY', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (86, 9, 'Q7', '4M', 2015, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (87, 9, 'Q8', '4MN', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (88, 9, 'e-tron GT', 'FW', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (89, 9, 'Q4 e-tron', 'FZ', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (90, 9, 'RS6 아반트', 'C8', 2020, NULL);

-- 폭스바겐 (brand_id = 10)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (91, 10, '골프', 'MK8', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (92, 10, '파사트', 'B8', 2015, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (93, 10, '티구안', 'AD', 2016, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (94, 10, '투아렉', 'CR', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (95, 10, '아테온', '3H', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (96, 10, 'ID.4', 'E2', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (97, 10, 'ID.Buzz', 'EB', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (98, 10, '폴로', 'AW', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (99, 10, '제타', 'A7', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (100, 10, 'T-Roc', 'A1', 2017, NULL);

-- 토요타 (brand_id = 11)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (101, 11, '캠리', 'XV70', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (102, 11, '코롤라', 'E210', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (103, 11, 'RAV4', 'XA50', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (104, 11, '하이랜더', 'XU70', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (105, 11, '프리우스', 'XW60', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (106, 11, 'bZ4X', 'EA10', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (107, 11, '크라운', 'S230', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (108, 11, '시에나', 'XL40', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (109, 11, '수프라', 'A90', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (110, 11, '랜드크루저', 'J300', 2021, NULL);

-- 혼다 (brand_id = 12)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (111, 12, '어코드', 'CV', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (112, 12, '시빅', 'FE', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (113, 12, 'CR-V', 'RW', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (114, 12, 'HR-V', 'RV', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (115, 12, '파일럿', 'YF', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (116, 12, '오딧세이', 'RL6', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (117, 12, 'e:NP1', 'EP', 2022, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (118, 12, '인사이트', 'ZE4', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (119, 12, '피트', 'GR', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (120, 12, '시빅 타입R', 'FL5', 2023, NULL);

-- 볼보 (brand_id = 13)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (121, 13, 'S60', 'Z', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (122, 13, 'S90', 'P', 2016, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (123, 13, 'XC40', 'X', 2018, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (124, 13, 'XC60', 'U', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (125, 13, 'XC90', 'L', 2015, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (126, 13, 'C40 Recharge', 'XC', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (127, 13, 'XC40 Recharge', 'XR', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (128, 13, 'EX90', 'EX', 2024, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (129, 13, 'V60', 'VZ', 2019, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (130, 13, 'V90', 'VP', 2016, NULL);

-- 테슬라 (brand_id = 14)
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (131, 14, '모델 3', 'M3', 2017, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (132, 14, '모델 Y', 'MY', 2020, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (133, 14, '모델 S', 'MS', 2012, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (134, 14, '모델 X', 'MX', 2015, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (135, 14, '사이버트럭', 'CT', 2023, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (136, 14, '모델 3 하이랜드', 'M3H', 2024, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (137, 14, '모델 Y 퍼포먼스', 'MYP', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (138, 14, '모델 S 플래드', 'MSP', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (139, 14, '모델 X 플래드', 'MXP', 2021, NULL);
INSERT INTO car_model (id, brand_id, name, variant, start_year, end_year) VALUES (140, 14, '세미', 'SM', 2022, NULL);
