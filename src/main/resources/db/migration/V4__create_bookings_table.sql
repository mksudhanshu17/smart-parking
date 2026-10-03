CREATE TABLE bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL ,
    parking_lot_id BIGINT NOT NULL ,
    parking_slot_id BIGINT NOT NULL ,
    status VARCHAR(20) NOT NULL ,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY(parking_lot_id) REFERENCES parking_lots(id),
    FOREIGN KEY (parking_slot_id) REFERENCES parking_slots(id),


);