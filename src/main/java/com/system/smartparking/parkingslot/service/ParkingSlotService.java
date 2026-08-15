package com.system.smartparking.parkingslot.service;

import com.system.smartparking.parkingslot.entity.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {

    ParkingSlot createParkingSlot(ParkingSlot parkingSlot);
    //admin creates an object of ParkingSlot and return type is also ParkingSlot which tells the id

    ParkingSlot getParkingSlotById(Long id);
    //return an object of ParkingSlot when admin enters id

    List<ParkingSlot> getAllParkingSlot();
    //return list of ParkingSlot(all objects) when admin asks

    ParkingSlot updateParkingSlot(Long id,ParkingSlot parkingSlot);
    //Update a specific ParkingSlot object when user enters id and updation details

    void deleteParkingSlot(Long id);
    //Delete by id
}
