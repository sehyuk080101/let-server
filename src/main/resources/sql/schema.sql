CREATE TABLE IF NOT EXISTS `user` (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    student_id BIGINT NOT NULL,
    real_name VARCHAR(255) NOT NULL,
    school_id BIGINT NOT NULL,
    role ENUM('ROLE_ADMIN', 'ROLE_USER') NOT NULL
    );