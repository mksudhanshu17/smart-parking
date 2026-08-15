CREATE TABLE parking_slots(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    slot_number VARCHAR(10) NOT NULL ,
    slot_status VARCHAR(20) NOT NULL,
    slot_type VARCHAR(20) NOT NULL ,
    per_hour_price DECIMAL(10,2) NOT NULL ,
    floor INTEGER NOT NULL ,
    parking_lot_id BIGINT NOT NULL ,
    FOREIGN KEY(parking_lot_id) REFERENCES parking_lots(id)

);