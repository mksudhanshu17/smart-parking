package com.system.smartparking.parkinglot.service;

import com.system.smartparking.exception.ResourceAlreadyExistsException;
import com.system.smartparking.exception.ResourceNotFoundException;
import com.system.smartparking.parkinglot.dto.CreateParkingLotRequest;
import com.system.smartparking.parkinglot.dto.ParkingLotResponse;
import com.system.smartparking.parkinglot.dto.UpdateParkingLotRequest;
import com.system.smartparking.parkinglot.entity.ParkingLot;
import com.system.smartparking.parkinglot.mapper.ParkingLotMapper;
import com.system.smartparking.parkinglot.repository.ParkingLotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ParkingLotServiceImpl implements ParkingLotService{
        private final ParkingLotMapper parkingLotMapper;
        private final ParkingLotRepository parkingLotRepository;

        // create Parking Lot
        @Transactional
        public ParkingLotResponse createParkingLot (CreateParkingLotRequest request){
                if(parkingLotRepository.existsByNameAndLocation(request.getName(), request.getLocation())){
                        throw new ResourceAlreadyExistsException("Parking lot already exists with same name and location!");
                }
                ParkingLot parkingLot = parkingLotMapper.mapToParkingLot(request);
                parkingLotRepository.save(parkingLot);
                return parkingLotMapper.mapToResponse(parkingLot);
        }

        // Get parking Lot by Id
        public ParkingLotResponse getParkingLotById (Long id){
                ParkingLot parkingLot = parkingLotRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Parking Lot not found!"));
                return parkingLotMapper.mapToResponse(parkingLot);
        }

        // Get list of all Parking Lots

        public List<ParkingLotResponse> getAllParkingLots(){
                List<ParkingLot> parkingLots = parkingLotRepository.findAll();
                List<ParkingLotResponse> response = new ArrayList<>() ;
                for(ParkingLot p : parkingLots){
                       response.add(parkingLotMapper.mapToResponse(p)) ;
                }
                return response;
        }

        // Update Parking Lot
        @Transactional
        public ParkingLotResponse updateParkingLot(Long id, UpdateParkingLotRequest request){
                ParkingLot parkingLot = parkingLotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Parking Lot not found!"));
                parkingLotMapper.updateFromRequest(request, parkingLot);

                return parkingLotMapper.mapToResponse(parkingLot);
        }

        // Delete Parking Lot
        @Transactional
        public void deleteParkingLot(Long id){
                ParkingLot parkingLot = parkingLotRepository.findById(id).orElseThrow(() ->(new ResourceNotFoundException("Parking Lot not found! ")));
                parkingLotRepository.delete(parkingLot);
        }
}
