package com.system.smartparking.parkingslot.service;

import com.system.smartparking.parkingslot.dto.CreateParkingSlotRequest;
import com.system.smartparking.parkingslot.dto.ParkingSlotResponse;
import com.system.smartparking.parkingslot.dto.UpdateParkingSlotRequest;
import com.system.smartparking.parkingslot.entity.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {

    ParkingSlotResponse createParkingSlot(CreateParkingSlotRequest request);
    //admin creates an object of ParkingSlot and return type is also ParkingSlot which tells the id

    ParkingSlotResponse getParkingSlotById(Long id);
    //return an object of ParkingSlot when admin enters id

    List<ParkingSlotResponse> getAllParkingSlot();
    //return list of ParkingSlot(all objects) when admin asks

    ParkingSlotResponse updateParkingSlot(Long id, UpdateParkingSlotRequest request);
    //Update a specific ParkingSlot object when user enters id and updation details

    void deleteParkingSlot(Long id);
    //Delete by id
}
