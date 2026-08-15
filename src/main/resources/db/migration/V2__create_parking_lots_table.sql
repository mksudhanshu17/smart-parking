CREATE TABLE parking_lots(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(30) NOT NULL ,
    location VARCHAR(30) NOT NULL ,
    total_floors INTEGER NOT NULL ,
    status VARCHAR(20) NOT NULL
);