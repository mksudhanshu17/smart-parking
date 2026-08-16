package com.system.smartparking.parkinglot.service;

import com.system.smartparking.parkinglot.dto.CreateParkingLotRequest;
import com.system.smartparking.parkinglot.dto.ParkingLotResponse;
import com.system.smartparking.parkinglot.mapper.ParkingLotMapper;
import com.system.smartparking.parkinglot.repository.ParkingLotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ParkingLotServiceImpl implements ParkingLotService{
        private final ParkingLotMapper parkingLotMapper;
        private final ParkingLotRepository parkingLotRepository;

        public ParkingLotResponse createParkingLot (CreateParkingLotRequest request){
                if(parkingLotRepository.existsByNameAndLocation(request.getName(), request.getLocation())){
                        throw new
                }
        }
}
