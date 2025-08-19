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


INSERT INTO Exercises (category, duration, title, description, method) VALUES
                                                                               ('MOVING', 5, '걷기 5분', '가장 기본적인 건강한 소화방법', '5분간 2~3바퀴 돌 정도로 걸어 보아요.'),
                                                                               ('MOVING', 7, '조깅 7분', '소화를 하며 체력도 올리는 효과적인 방법', '가볍게 땀이 날 정도 속도로 뛰어 보아요.'),
                                                                               ('STRETCH', 2, '목 스트레칭 2분', '건강한 목을 위해 목 스트레칭을 해 보아요.', '좌우·앞뒤로 천천히 10회씩 해 보아요.'),
                                                                               ( 'STRETCH', 1, '어깨 돌리기 1분', '건강한 어깨를 위해 어깨 스트레칭을 해 보아요.', '앞·뒤 각각 10회씩 해 보아요.'),
                                                                               ( 'STRETCH', 1, '허리 옆으로 숙이기 1분', '펴진 허리를 위해 허리 스트레칭을 해 보아요.', '좌우 번갈아 10회씩 해 보아요.'),
                                                                               ( 'STRETCH', 2, '벽 짚고 종아리 스트레칭 2분', '뭉쳐있는 다리 근육을 풀어 보아요.', '좌우 각 30초씩 2회씩 해 보아요.'),
                                                                               ( 'STRETCH', 1, '몸 앞으로 굽히기 1분', '온몸을 한번에 풀어 보아요.', '1분동안 최대한 오래 굽혀보아요.'),
                                                                               ( 'ETC', 2, '복식호흡 2분', '온몸의 스트레스를 풀어 보아요.', '4초 들이마시기, 4초 내쉬기 반복해요.');
