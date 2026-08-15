package com.system.smartparking.parkingslot.controller;

import com.system.smartparking.parkingslot.entity.ParkingSlot;
import com.system.smartparking.parkingslot.service.ParkingSlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-slots")
public class ParkingSlotController {

    private final ParkingSlotService parkingSlotService;

    public ParkingSlotController(ParkingSlotService parkingSlotService){
        this.parkingSlotService = parkingSlotService;
    }

    @PostMapping //create
    public ResponseEntity<ParkingSlot> createParkingSlot(@RequestBody ParkingSlot parkingSlot){

        ParkingSlot createdSlot = parkingSlotService.createParkingSlot(parkingSlot);
        //saving this in a variable cuz we might use it somewhere else basically a better practice
        //then directly returning

        return ResponseEntity.ok(createdSlot);
        //using ResponseEntity as the return type instead of directly using ParkingSlot gives us complete
        //control over the http response protocol
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSlot> getParkingSlotById(@PathVariable Long id){

        ParkingSlot parkingSlot = parkingSlotService.getParkingSlotById(id);
        return ResponseEntity.ok(parkingSlot);
    }

    @GetMapping
    public ResponseEntity<List<ParkingSlot>> getAllParkingSlot(){

     List<ParkingSlot> parkingSlots = parkingSlotService.getAllParkingSlot();
     return ResponseEntity.ok(parkingSlots);
    }

    @PutMapping("{id}")
    public ResponseEntity<ParkingSlot> updateParkingSlot(@PathVariable Long id,@RequestBody ParkingSlot parkingSlot){

        ParkingSlot updatedSlot = parkingSlotService.updateParkingSlot(id,parkingSlot);
        return ResponseEntity.ok(updatedSlot);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteParkingSlot(@PathVariable Long id){

        parkingSlotService.deleteParkingSlot(id);
        return ResponseEntity.noContent().build();
    }


}
