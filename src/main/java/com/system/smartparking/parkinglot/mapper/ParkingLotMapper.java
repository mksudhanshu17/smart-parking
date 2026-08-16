package com.system.smartparking.parkinglot.mapper;

import com.system.smartparking.parkinglot.dto.CreateParkingLotRequest;
import com.system.smartparking.parkinglot.dto.ParkingLotResponse;
import com.system.smartparking.parkinglot.dto.UpdateParkingLotRequest;
import com.system.smartparking.parkinglot.entity.ParkingLot;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {
    public ParkingLot mapToParkingLot (CreateParkingLotRequest request){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(request.getName());
        parkingLot.setLocation(request.getLocation());
        parkingLot.setTotalFloors(request.getTotalFloors());
        return parkingLot;
    }

    public ParkingLotResponse mapToResponse (ParkingLot parkingLot){
        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();
        parkingLotResponse.setId(parkingLot.getId());
        parkingLotResponse.setName(parkingLot.getName());
        parkingLotResponse.setLocation(parkingLot.getLocation());
        parkingLotResponse.setTotalFloors(parkingLot.getTotalFloors());
        parkingLotResponse.setStatus(parkingLot.getStatus());
        return parkingLotResponse;
    }

    public void updateFromRequest (UpdateParkingLotRequest request, ParkingLot parkingLot){
        if(request.getName() != null && !request.getName().isBlank()){
            parkingLot.setName(request.getName());
        }

        if(request.getLocation() != null && !request.getLocation().isBlank()){
            parkingLot.setLocation(request.getLocation());
        }

        if(request.getTotalFloors() != null){
            parkingLot.setTotalFloors(request.getTotalFloors());
        }
    }
}
