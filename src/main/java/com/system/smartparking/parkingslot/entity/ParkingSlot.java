package com.system.smartparking.parkingslot.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "parking_slots")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotNumber; // for example A01,B02

    @Enumerated(EnumType.STRING)//this tells jpa that enum is stored as string in db
    private SlotStatus slotStatus; //enum cuz it can be reserved , occupied

    @Enumerated(EnumType.STRING)//this tells jpa that enum is stored as string in db
    private SlotType slotType; //enum cuz it can be bike,car ,ev ,etc

    private BigDecimal perHourPrice ; // why not use double?cuz double sometimes can produce
    //values like 120.9999999 so we always use bigdecimal for money

    @Column(nullable = false)
    private Integer floor; // example 0,1,2,3

  //  @ManyToOne// now multiple parking slots can belong to a single parkinglot
  // @JoinColumn(name ="parking_slot_id")
  //  private ParkingLot parkingLot; //rn error cuz ParkingLot entity doesnt exist
}
