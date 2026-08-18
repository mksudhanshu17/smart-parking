package com.system.smartparking.parkingslot.mapper;
import com.system.smartparking.parkingslot.dto.CreateParkingSlotRequest;
import com.system.smartparking.parkingslot.dto.ParkingSlotResponse;
import com.system.smartparking.parkingslot.dto.UpdateParkingSlotRequest;
import com.system.smartparking.parkingslot.entity.ParkingSlot;
import org.springframework.stereotype.Component;

@Component

public class ParkingSlotMapper {
    public ParkingSlot mapToParkingSlot(CreateParkingSlotRequest request) {
        ParkingSlot parkingSlot = new ParkingSlot();

        parkingSlot.setSlotNumber(request.getSlotNumber());
        parkingSlot.setSlotType(request.getSlotType());
        parkingSlot.setPerHourPrice(request.getPerHourPrice());
        parkingSlot.setFloor(request.getFloor());


        return parkingSlot;
    }

    public ParkingSlotResponse mapToResponse(ParkingSlot parkingSlot){
        ParkingSlotResponse parkingSlotResponse = new ParkingSlotResponse();

        parkingSlotResponse.setId(parkingSlot.getId());
        parkingSlotResponse.setSlotStatus(parkingSlot.getSlotStatus());
        parkingSlotResponse.setSlotType(parkingSlot.getSlotType());
        parkingSlotResponse.setPerHourPrice(parkingSlot.getPerHourPrice());
        parkingSlotResponse.setFloor(parkingSlot.getFloor());
        parkingSlotResponse.setParkingLotId(parkingSlot.getParkingLot().getId());
        parkingSlotResponse.setSlotNumber(parkingSlot.getSlotNumber());
        return parkingSlotResponse;
    }

    public void updateFromRequest (UpdateParkingSlotRequest request , ParkingSlot parkingSlot){

        parkingSlot.setSlotStatus(request.getSlotStatus());
        parkingSlot.setPerHourPrice(request.getPerHourPrice());

    }
}

