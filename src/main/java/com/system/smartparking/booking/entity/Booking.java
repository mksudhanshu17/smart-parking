package com.system.smartparking.booking.entity;

import com.system.smartparking.parkinglot.entity.ParkingLot;
import com.system.smartparking.parkingslot.entity.ParkingSlot;
import com.system.smartparking.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id",nullable = false)
    private ParkingLot parkingLot;

    @ManyToOne
    @JoinColumn(name ="parking_slot_id", nullable = false)
    private ParkingSlot parkingSlot;

    @ManyToOne()
    @JoinColumn(name ="user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;


    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
