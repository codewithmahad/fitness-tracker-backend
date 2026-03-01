-- V1__init.sql

-- 1. Create Users Table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(254) UNIQUE NOT NULL, -- Adjusted to 254 for strict RFC compliance
    password CHAR(60) NOT NULL,         -- Optimized for BCrypt
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    role ENUM('USER', 'ADMIN') NOT NULL DEFAULT 'USER',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2. Create Activities Table
CREATE TABLE activities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    type ENUM('RUNNING', 'CYCLING', 'SWIMMING', 'WALKING', 'GYM') NOT NULL,
    duration INT NOT NULL COMMENT 'Duration in minutes',
    calories_burned INT DEFAULT 0,
    start_time DATETIME NOT NULL,
    additional_metrics JSON, -- Left nullable for flexibility
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- Foreign Key
    CONSTRAINT fk_activities_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,

    -- Data Integrity Checks
    CONSTRAINT check_positive_duration CHECK (duration > 0),
    CONSTRAINT check_non_negative_calories CHECK (calories_burned >= 0),

    -- Performance: Composite Index for filtering by user and date
    INDEX idx_user_start_time (user_id, start_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3. Create Recommendations Table
CREATE TABLE recommendations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    activity_id BIGINT NOT NULL,
    improvements JSON,
    suggestions JSON,
    safety JSON,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- Foreign Keys
    CONSTRAINT fk_recom_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_recom_activity FOREIGN KEY (activity_id) REFERENCES activities(id) ON DELETE CASCADE,

    -- Business Logic + Leftmost Index:
    -- This handles BOTH uniqueness AND performance for user_id queries.
    UNIQUE KEY unique_user_activity (user_id, activity_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;