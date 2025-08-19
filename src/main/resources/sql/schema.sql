-- User 테이블
CREATE TABLE IF NOT EXISTS `User` (
                                      `user_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                      `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `student_id` BIGINT NOT NULL UNIQUE,
    `real_name` VARCHAR(255) NOT NULL,
    `role` ENUM('ROLE_ADMIN', 'ROLE_USER') NOT NULL
    );

-- Allergy 테이블
CREATE TABLE IF NOT EXISTS `Allergy` (
                                         `allergy_idx` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         `allergy_name` VARCHAR(255) NOT NULL
    );

-- Menu 테이블
CREATE TABLE IF NOT EXISTS `Menu` (
                                      `menu_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                      `menu_name` VARCHAR(255) NOT NULL,
    `menu_score` DOUBLE NOT NULL DEFAULT 0.0,
    `like_count` BIGINT NOT NULL DEFAULT 0,
    `dislike_count` BIGINT NOT NULL DEFAULT 0,
    `current_rank` INT DEFAULT NULL
    );

-- Meal 테이블
CREATE TABLE IF NOT EXISTS `Meal` (
                                      `meal_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                      `meal_date` DATE NOT NULL,
                                      `meal_type` ENUM('조식', '중식', '석식') NOT NULL,
    `score` FLOAT NOT NULL DEFAULT 0.0,
    `calorie` FLOAT NOT NULL DEFAULT 0.0,
    UNIQUE (`meal_date`, `meal_type`)
    );

-- MealMenu (중간 테이블)
CREATE TABLE IF NOT EXISTS `MealMenu` (
                                          `meal_menu_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                          `menu_id` BIGINT NOT NULL,
                                          `meal_id` INT NOT NULL,
                                          UNIQUE (`menu_id`, `meal_id`),
    FOREIGN KEY (`menu_id`) REFERENCES `Menu` (`menu_id`) ON DELETE CASCADE,
    FOREIGN KEY (`meal_id`) REFERENCES `Meal` (`meal_id`) ON DELETE CASCADE
    );

-- MenuAllergy (중간 테이블)
CREATE TABLE IF NOT EXISTS `MenuAllergy` (
                                             `menu_allergy_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                             `allergy_idx` BIGINT NOT NULL,
                                             `menu_id` BIGINT NOT NULL,
                                             UNIQUE (`allergy_idx`, `menu_id`),
    FOREIGN KEY (`allergy_idx`) REFERENCES `Allergy` (`allergy_idx`) ON DELETE CASCADE,
    FOREIGN KEY (`menu_id`) REFERENCES `Menu` (`menu_id`) ON DELETE CASCADE
    );

-- Eater 테이블
CREATE TABLE IF NOT EXISTS `Eater` (
                                       `eater_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       `user_id` BIGINT NOT NULL,
                                       `meal_id` INT NOT NULL,
                                       `eaten` BOOLEAN NOT NULL DEFAULT FALSE,
                                       UNIQUE (`user_id`, `meal_id`),
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`meal_id`) REFERENCES `Meal` (`meal_id`) ON DELETE CASCADE
    );

-- MealRating 테이블
CREATE TABLE IF NOT EXISTS `MealRating` (
                                            `meal_rating_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                            `meal_id` INT NOT NULL,
                                            `rating` FLOAT NOT NULL,
                                            FOREIGN KEY (`meal_id`) REFERENCES `Meal` (`meal_id`) ON DELETE CASCADE
    );

-- MenuRankHistory 테이블
CREATE TABLE IF NOT EXISTS `MenuRankHistory` (
                                                 `history_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                                 `menu_id` BIGINT NOT NULL,
                                                 `date` DATE NOT NULL,
                                                 `rank` INT NOT NULL,
                                                 `rank_diff` INT NOT NULL,
                                                 UNIQUE (`menu_id`, `date`),
    FOREIGN KEY (`menu_id`) REFERENCES `Menu` (`menu_id`) ON DELETE CASCADE
    );


CREATE TABLE IF NOT EXISTS `Exercises` (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           category ENUM('MOVING', 'STRETCH', 'ETC') NOT NULL,
                           duration INT NOT NULL,
                           title VARCHAR(100) NOT NULL,
                           description VARCHAR(255) NOT NULL,
                           method VARCHAR(255) NOT NULL
);

INSERT INTO `Allergy` (`allergy_name`) VALUES
                                           ('난류(계란 등)'),
                                           ('우유'),
                                           ('메밀'),
                                           ('땅콩'),
                                           ('대두(콩)'),
                                           ('밀'),
                                           ('고등어'),
                                           ('게'),
                                           ('새우'),
                                           ('돼지고기'),
                                           ('복숭아'),
                                           ('토마토'),
                                           ('아황산염'),
                                           ('호두'),
                                           ('닭고기'),
                                           ('소고기'),
                                           ('오징어'),
                                           ('조개류(굴, 전복, 홍합 포함)'),
                                           ('잣');


INSERT INTO Exercises (id, category, duration, title, description, method) VALUES
                                                                               (1, 'MOVING', 5, '걷기 5분', '가장 기본적인 건강한 소화방법', '5분간 2~3바퀴 돌 정도로 걸어 보아요.'),
                                                                               (2, 'MOVING', 7, '조깅 7분', '소화를 하며 체력도 올리는 효과적인 방법', '가볍게 땀이 날 정도 속도로 뛰어 보아요.'),
                                                                               (3, 'STRETCH', 2, '목 스트레칭 2분', '건강한 목을 위해 목 스트레칭을 해 보아요.', '좌우·앞뒤로 천천히 10회씩 해 보아요.'),
                                                                               (4, 'STRETCH', 1, '어깨 돌리기 1분', '건강한 어깨를 위해 어깨 스트레칭을 해 보아요.', '앞·뒤 각각 10회씩 해 보아요.'),
                                                                               (5, 'STRETCH', 1, '허리 옆으로 숙이기 1분', '펴진 허리를 위해 허리 스트레칭을 해 보아요.', '좌우 번갈아 10회씩 해 보아요.'),
                                                                               (6, 'STRETCH', 2, '벽 짚고 종아리 스트레칭 2분', '뭉쳐있는 다리 근육을 풀어 보아요.', '좌우 각 30초씩 2회씩 해 보아요.'),
                                                                               (7, 'STRETCH', 1, '몸 앞으로 굽히기 1분', '온몸을 한번에 풀어 보아요.', '1분동안 최대한 오래 굽혀보아요.'),
                                                                               (8, 'ETC', 2, '복식호흡 2분', '온몸의 스트레스를 풀어 보아요.', '4초 들이마시기, 4초 내쉬기 반복해요.');

-- 트랜잭션 시작
START TRANSACTION;

-- 1) 사용자 더미 (총 30명)
INSERT INTO `User` (`user_id`, `username`, `password`, `student_id`, `real_name`, `role`) VALUES
                                                                                              (1,'user01','pass','101','홍길동1','ROLE_USER'),
                                                                                              (2,'user02','pass','102','홍길동2','ROLE_USER'),
                                                                                              (3,'user03','pass','103','홍길동3','ROLE_USER'),
                                                                                              (4,'user04','pass','104','홍길동4','ROLE_USER'),
                                                                                              (5,'user05','pass','105','홍길동5','ROLE_USER'),
                                                                                              (6,'user06','pass','106','홍길동6','ROLE_USER'),
                                                                                              (7,'user07','pass','107','홍길동7','ROLE_USER'),
                                                                                              (8,'user08','pass','108','홍길동8','ROLE_USER'),
                                                                                              (9,'user09','pass','109','홍길동9','ROLE_USER'),
                                                                                              (10,'user10','pass','110','홍길동10','ROLE_USER'),
                                                                                              (11,'user11','pass','111','홍길동11','ROLE_USER'),
                                                                                              (12,'user12','pass','112','홍길동12','ROLE_USER'),
                                                                                              (13,'user13','pass','113','홍길동13','ROLE_USER'),
                                                                                              (14,'user14','pass','114','홍길동14','ROLE_USER'),
                                                                                              (15,'user15','pass','115','홍길동15','ROLE_USER'),
                                                                                              (16,'user16','pass','116','홍길동16','ROLE_USER'),
                                                                                              (17,'user17','pass','117','홍길동17','ROLE_USER'),
                                                                                              (18,'user18','pass','118','홍길동18','ROLE_USER'),
                                                                                              (19,'user19','pass','119','홍길동19','ROLE_USER'),
                                                                                              (20,'user20','pass','120','홍길동20','ROLE_USER'),
                                                                                              (21,'user21','pass','121','홍길동21','ROLE_USER'),
                                                                                              (22,'user22','pass','122','홍길동22','ROLE_USER'),
                                                                                              (23,'user23','pass','123','홍길동23','ROLE_USER'),
                                                                                              (24,'user24','pass','124','홍길동24','ROLE_USER'),
                                                                                              (25,'user25','pass','125','홍길동25','ROLE_USER'),
                                                                                              (26,'user26','pass','126','홍길동26','ROLE_USER'),
                                                                                              (27,'user27','pass','127','홍길동27','ROLE_USER'),
                                                                                              (28,'user28','pass','128','홍길동28','ROLE_USER'),
                                                                                              (29,'user29','pass','129','홍길동29','ROLE_USER'),
                                                                                              (30,'user30','pass','130','홍길동30','ROLE_USER')
    ON DUPLICATE KEY UPDATE username=VALUES(username);

-- 2) 메뉴 더미 (명시적 ID 사용)
INSERT INTO `Menu` (`menu_id`, `menu_name`, `menu_score`, `like_count`, `dislike_count`, `current_rank`) VALUES
                                                                                                             (1001,'현미시리얼&우유',0,10,1,5),
                                                                                                             (1002,'양송이크림스프',0,7,2,12),
                                                                                                             (1003,'꼬마피자',0,12,3,8),
                                                                                                             (1004,'모듬야채피클',0,3,0,25),
                                                                                                             (1005,'쁘띠첼',0,5,1,18),

                                                                                                             (1011,'수제블루베리요거트',0,9,2,10),
                                                                                                             (1012,'홍춘천닭갈비',0,14,5,6),
                                                                                                             (1013,'도라지오이무침',0,6,1,22),
                                                                                                             (1014,'발아현미밥',0,4,0,28),
                                                                                                             (1015,'배추김치',0,2,1,30),
                                                                                                             (1016,'왕만두육개장',0,8,3,11),

                                                                                                             (1021,'계란실파국',0,6,1,16),
                                                                                                             (1022,'샐러드바/드레싱',0,13,4,9),
                                                                                                             (1023,'뿌링클돈까스',0,20,6,2),
                                                                                                             (1024,'차조밥',0,3,0,26),
                                                                                                             (1025,'깍두기',0,4,1,24)
    ON DUPLICATE KEY UPDATE menu_name=VALUES(menu_name);

-- 3) Meal 더미 (조/중/석 3일치, 칼로리는 "급식 총 칼로리")
INSERT INTO `Meal` (`meal_id`, `meal_date`, `meal_type`, `score`, `calorie`) VALUES
-- 2025-08-25
(2001,'2025-08-25','조식', 0.0, 670.0),
(2002,'2025-08-25','중식', 0.0, 1066.0),
(2003,'2025-08-25','석식', 0.0, 805.5),
-- 2025-08-26
(2004,'2025-08-26','조식', 0.0, 668.0),
(2005,'2025-08-26','중식', 0.0, 1204.7),
(2006,'2025-08-26','석식', 0.0, 1064.6),
-- 2025-08-27 (질문 예시와 유사 수치)
(2007,'2025-08-27','조식', 0.0, 674.7),
(2008,'2025-08-27','중식', 0.0, 893.2),
(2009,'2025-08-27','석식', 0.0, 598.2)
    ON DUPLICATE KEY UPDATE calorie=VALUES(calorie);

-- 4) MealMenu 매핑
-- 2025-08-25
INSERT INTO `MealMenu` (`meal_menu_id`, `menu_id`, `meal_id`) VALUES
                                                                  (30001,1001,2001),(30002,1002,2001),(30003,1003,2001),(30004,1004,2001),(30005,1005,2001),
                                                                  (30006,1012,2002),(30007,1016,2002),(30008,1014,2002),(30009,1013,2002),(30010,1015,2002),
                                                                  (30011,1021,2003),(30012,1022,2003),(30013,1023,2003),(30014,1025,2003),(30015,1024,2003)
    ON DUPLICATE KEY UPDATE menu_id=VALUES(menu_id);

-- 2025-08-26
INSERT INTO `MealMenu` (`meal_menu_id`, `menu_id`, `meal_id`) VALUES
                                                                  (30016,1001,2004),(30017,1002,2004),(30018,1005,2004),
                                                                  (30019,1016,2005),(30020,1012,2005),(30021,1015,2005),
                                                                  (30022,1023,2006),(30023,1022,2006),(30024,1021,2006)
    ON DUPLICATE KEY UPDATE menu_id=VALUES(menu_id);

-- 2025-08-27 (질문 예시 구성 반영)
INSERT INTO `MealMenu` (`meal_menu_id`, `menu_id`, `meal_id`) VALUES
                                                                  (30025,1001,2007),(30026,1002,2007),(30027,1003,2007),(30028,1004,2007),(30029,1005,2007),
                                                                  (30030,1011,2008),(30031,1012,2008),(30032,1013,2008),(30033,1014,2008),(30034,1015,2008),(30035,1016,2008),
                                                                  (30036,1023,2009),(30037,1024,2009),(30038,1025,2009),(30039,1021,2009),(30040,1022,2009)
    ON DUPLICATE KEY UPDATE menu_id=VALUES(menu_id);

-- 5) Eater (식사자) 더미: 일부 사용자만 각 급식을 먹었다고 표시
-- 조식은 참여율 낮게(대략 30~40%), 중식 높게(60~80%), 석식 중간(40~60%) 정도로 분포
-- 2025-08-27 기준
INSERT INTO `Eater` (`eater_id`, `user_id`, `meal_id`, `eaten`) VALUES
-- 2007 (조식) user 1..10 중 1,2,3,4,5만 섭취
(40001,1,2007,TRUE),(40002,2,2007,TRUE),(40003,3,2007,TRUE),(40004,4,2007,TRUE),(40005,5,2007,TRUE),
-- 2008 (중식) user 1..20 중 1..15 섭취
(40006,1,2008,TRUE),(40007,2,2008,TRUE),(40008,3,2008,TRUE),(40009,4,2008,TRUE),(40010,5,2008,TRUE),
(40011,6,2008,TRUE),(40012,7,2008,TRUE),(40013,8,2008,TRUE),(40014,9,2008,TRUE),(40015,10,2008,TRUE),
(40016,11,2008,TRUE),(40017,12,2008,TRUE),(40018,13,2008,TRUE),(40019,14,2008,TRUE),(40020,15,2008,TRUE),
-- 2009 (석식) user 1..12 중 1..8 섭취
(40021,1,2009,TRUE),(40022,2,2009,TRUE),(40023,3,2009,TRUE),(40024,4,2009,TRUE),
(40025,5,2009,TRUE),(40026,6,2009,TRUE),(40027,7,2009,TRUE),(40028,8,2009,TRUE)
    ON DUPLICATE KEY UPDATE eaten=VALUES(eaten);

-- 6) MealRating 더미 (평균 평점 계산용)
INSERT INTO `MealRating` (`meal_rating_id`, `meal_id`, `rating`) VALUES
                                                                     (50001,2007,4.0),(50002,2007,3.5),(50003,2007,3.8),
                                                                     (50004,2008,4.2),(50005,2008,4.0),(50006,2008,4.4),
                                                                     (50007,2009,3.6),(50008,2009,3.8)
    ON DUPLICATE KEY UPDATE rating=VALUES(rating);

-- 7) 메뉴 랭킹 히스토리 (간단)
INSERT INTO `MenuRankHistory` (`history_id`, `menu_id`, `date`, `rank`, `rank_diff`) VALUES
                                                                                         (60001,1023,'2025-08-20',2, +1),
                                                                                         (60002,1012,'2025-08-20',6, -1),
                                                                                         (60003,1003,'2025-08-20',8, +2),
                                                                                         (60004,1011,'2025-08-20',10, +3),
                                                                                         (60005,1001,'2025-08-20',5,  0)
    ON DUPLICATE KEY UPDATE rank=VALUES(rank), rank_diff=VALUES(rank_diff);

-- 8) 알레르기-메뉴 매핑 예시 (선택적)
-- 우유(2) 포함 메뉴 몇 개에 매핑
INSERT INTO `MenuAllergy` (`menu_allergy_id`, `allergy_idx`, `menu_id`) VALUES
                                                                            (70001,2,1001), -- 현미시리얼&우유
                                                                            (70002,2,1011), -- 수제블루베리요거트
                                                                            (70003,2,1022)  -- 샐러드바/드레싱(드레싱에 유제품 가정)
    ON DUPLICATE KEY UPDATE allergy_idx=VALUES(allergy_idx);

COMMIT;