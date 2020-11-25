-- --------------------------------
-- SCHEMA registration_and_login
-- --------------------------------
CREATE SCHEMA IF NOT EXISTS registration_and_login DEFAULT CHARACTER SET utf8;
USE registration_and_login;


-- --------------------------------
-- TABLE registration_and_login -> user
-- --------------------------------
CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(32) NOT NULL UNIQUE ,
    email VARCHAR(255) NOT NULL UNIQUE ,
    password VARCHAR(255) NOT NULL ,
    admin TINYINT(1) NOT NULL DEFAULT '0' COMMENT 'Is this user an admin 1-yes, 0-no',
    PRIMARY KEY (id)
);