-- User 테이블
CREATE TABLE `User` (
                        `user_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `username` VARCHAR(255) NOT NULL,
                        `password` VARCHAR(255) NOT NULL,
                        `student_id` BIGINT NOT NULL UNIQUE,
                        `real_name` VARCHAR(255) NOT NULL,
                        `role` ENUM('ROLE_ADMIN', 'ROLE_USER') NOT NULL
);

-- Allergy 테이블
CREATE TABLE `Allergy` (
                           `allergy_idx` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           `allergy_name` VARCHAR(255) NOT NULL
);

-- Menu 테이블
CREATE TABLE `Menu` (
                        `menu_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `menu_name` VARCHAR(255) NOT NULL,
                        `menu_score` DOUBLE NOT NULL DEFAULT 0.0,
                        `like_count` BIGINT NOT NULL DEFAULT 0,
                        `dislike_count` BIGINT NOT NULL DEFAULT 0,
                        `current_rank` INT DEFAULT NULL
);

-- Meal 테이블
CREATE TABLE `Meal` (
                        `meal_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `meal_date` DATE NOT NULL,
                        `meal_type` ENUM('조식', '중식', '석식') NOT NULL,
                        `score` FLOAT NOT NULL DEFAULT 0.0,
                        `calorie` FLOAT NOT NULL DEFAULT 0.0,
                        UNIQUE (`meal_date`, `meal_type`)
);

-- MealMenu (중간 테이블)
CREATE TABLE `MealMenu` (
                            `meal_menu_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            `menu_id` BIGINT NOT NULL,
                            `meal_id` INT NOT NULL,
                            UNIQUE (`menu_id`, `meal_id`),
                            FOREIGN KEY (`menu_id`) REFERENCES `Menu` (`menu_id`),
                            FOREIGN KEY (`meal_id`) REFERENCES `Meal` (`meal_id`)
);

-- MenuAllergy (중간 테이블)
CREATE TABLE `MenuAllergy` (
                               `menu_allergy_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                               `allergy_idx` BIGINT NOT NULL,
                               `menu_id` BIGINT NOT NULL,
                               UNIQUE (`allergy_idx`, `menu_id`),
                               FOREIGN KEY (`allergy_idx`) REFERENCES `Allergy` (`allergy_idx`),
                               FOREIGN KEY (`menu_id`) REFERENCES `Menu` (`menu_id`)
);

-- Eater 테이블
CREATE TABLE `Eater` (
                         `eater_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `user_id` BIGINT NOT NULL,
                         `meal_id` INT NOT NULL,
                         `eaten` BOOLEAN NOT NULL DEFAULT FALSE,
                         `first_grade_total_cnt` INT NOT NULL DEFAULT 0,
                         `second_grade_total_cnt` INT NOT NULL DEFAULT 0,
                         `third_grade_cnt` INT NOT NULL DEFAULT 0,
                         UNIQUE (`user_id`, `meal_id`),
                         FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`),
                         FOREIGN KEY (`meal_id`) REFERENCES `Meal` (`meal_id`)
);

-- MealRating 테이블
CREATE TABLE `MealRating` (
                              `meal_rating_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              `meal_id` INT NOT NULL,
                              `rating` FLOAT NOT NULL,
                              FOREIGN KEY (`meal_id`) REFERENCES `Meal` (`meal_id`)
);

-- MenuRankHistory 테이블
CREATE TABLE `MenuRankHistory` (
                                   `history_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                   `menu_id` BIGINT NOT NULL,
                                   `date` DATE NOT NULL,
                                   `rank` INT NOT NULL,
                                   `rank_diff` INT NOT NULL,
                                   UNIQUE (`menu_id`, `date`),
                                   FOREIGN KEY (`menu_id`) REFERENCES `Menu` (`menu_id`)
);
