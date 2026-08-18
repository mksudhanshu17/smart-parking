package com.system.smartparking.parkingslot.service;

import com.system.smartparking.exception.ResourceNotFoundException;
import com.system.smartparking.parkinglot.entity.ParkingLot;
import com.system.smartparking.parkingslot.dto.CreateParkingSlotRequest;
import com.system.smartparking.parkingslot.dto.ParkingSlotResponse;
import com.system.smartparking.parkingslot.dto.UpdateParkingSlotRequest;
import com.system.smartparking.parkingslot.entity.ParkingSlot;
import com.system.smartparking.parkingslot.mapper.ParkingSlotMapper;
import com.system.smartparking.parkingslot.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingSlotMapper parkingSlotMapper;

    public ParkingSlotServiceImpl(ParkingSlotRepository parkingSlotRepository, ParkingSlotMapper parkingSlotMapper){
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingSlotMapper = parkingSlotMapper;
    }

    @Override
    public ParkingSlotResponse createParkingSlot(CreateParkingSlotRequest request){
        ParkingSlot parkingSlot = parkingSlotMapper.mapToParkingSlot(request);
        parkingSlotRepository.save(parkingSlot);
        return parkingSlotMapper.mapToResponse(parkingSlot);
    }

    @Override
    public ParkingSlotResponse getParkingSlotById(Long id){

        ParkingSlot parkingSlot = parkingSlotRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Parking Slot not found"));

        return parkingSlotMapper.mapToResponse(parkingSlot);
    }

    @Override
    public List<ParkingSlotResponse> getAllParkingSlot(){

        List <ParkingSlot> parkingSlots = parkingSlotRepository.findAll();
        List <ParkingSlotResponse> parkingSlotResponses = new ArrayList<>();
        for(ParkingSlot s : parkingSlots){
            parkingSlotResponses.add(parkingSlotMapper.mapToResponse(s));
        }
        return parkingSlotResponses;
    }

    @Override
    public ParkingSlotResponse updateParkingSlot(Long id, UpdateParkingSlotRequest request){
        ParkingSlot existingSlot = parkingSlotRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parking Lot not found!"));;



        return parkingSlotMapper.mapToResponse(existingSlot);

    }

    @Override
    public void deleteParkingSlot(Long id){

        parkingSlotRepository.deleteById(id);
    }
}

