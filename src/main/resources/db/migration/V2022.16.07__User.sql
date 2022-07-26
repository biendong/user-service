CREATE TABLE `user` (
    id INT PRIMARY key AUTO_INCREMENT,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    full_name VARCHAR(250) NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL
);