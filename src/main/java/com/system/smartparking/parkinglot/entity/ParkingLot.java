package com.system.smartparking.parkinglot.entity;

import com.system.smartparking.parkingslot.entity.ParkingSlot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name= "parking_lots")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer totalFloors;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParkingLotStatus status = ParkingLotStatus.ACTIVE;

    @OneToMany(mappedBy = "parkingLot")
    private List<ParkingSlot> parkingSlots;
}
