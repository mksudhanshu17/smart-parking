package com.system.smartparking.parkingslot.repository;

import com.system.smartparking.parkingslot.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot,Long> {
}
