package com.system.smartparking.parkinglot.service;

import com.system.smartparking.parkinglot.dto.CreateParkingLotRequest;
import com.system.smartparking.parkinglot.dto.ParkingLotResponse;
import com.system.smartparking.parkinglot.dto.UpdateParkingLotRequest;

import java.util.List;

public interface ParkingLotService {
    ParkingLotResponse createParkingLot (CreateParkingLotRequest request);

    ParkingLotResponse getParkingLotById(Long id);

    ParkingLotResponse updateParkingLot(UpdateParkingLotRequest request);

    List<ParkingLotResponse> getAllParkingLots();

    void deleteParkingLot(Long id);
}
