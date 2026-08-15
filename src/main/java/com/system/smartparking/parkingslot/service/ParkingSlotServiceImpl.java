package com.system.smartparking.parkingslot.service;

import com.system.smartparking.parkingslot.entity.ParkingSlot;
import com.system.smartparking.parkingslot.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    private final ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotServiceImpl(ParkingSlotRepository parkingSlotRepository){
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public ParkingSlot createParkingSlot(ParkingSlot parkingSlot){

        return parkingSlotRepository.save(parkingSlot);
    }

    @Override
    public ParkingSlot getParkingSlotById(Long id){

        return parkingSlotRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Parking slot not found"));
    }

    @Override
    public List<ParkingSlot> getAllParkingSlot(){

        return parkingSlotRepository.findAll();
    }

    @Override
    public ParkingSlot updateParkingSlot(Long id, ParkingSlot parkingSlot){
        ParkingSlot existingSlot = getParkingSlotById(id);

        existingSlot.setSlotNumber(parkingSlot.getSlotNumber());
        existingSlot.setSlotStatus(parkingSlot.getSlotStatus());
        existingSlot.setSlotType(parkingSlot.getSlotType());
        existingSlot.setPerHourPrice(parkingSlot.getPerHourPrice());
        existingSlot.setFloor(parkingSlot.getFloor());

        return parkingSlotRepository.save(existingSlot);

    }

    @Override
    public void deleteParkingSlot(Long id){

        parkingSlotRepository.deleteById(id);
    }
}

