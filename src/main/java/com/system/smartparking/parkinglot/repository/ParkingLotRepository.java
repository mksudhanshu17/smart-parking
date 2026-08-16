package com.system.smartparking.parkinglot.repository;

import com.system.smartparking.parkinglot.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
        boolean existsByNameAndLocation(String name, String location);
}
