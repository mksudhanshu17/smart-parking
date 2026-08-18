package com.system.smartparking.parkingslot.controller;

import com.system.smartparking.parkingslot.dto.CreateParkingSlotRequest;
import com.system.smartparking.parkingslot.dto.ParkingSlotResponse;
import com.system.smartparking.parkingslot.dto.UpdateParkingSlotRequest;
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
    public ResponseEntity<ParkingSlotResponse> createParkingSlot(@RequestBody CreateParkingSlotRequest request){

        ParkingSlotResponse response = parkingSlotService.createParkingSlot(request);
        //saving this in a variable cuz we might use it somewhere else basically a better practice
        //then directly returning

        return ResponseEntity.ok(response);
        //using ResponseEntity as the return type instead of directly using ParkingSlot gives us complete
        //control over the http response protocol
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSlotResponse> getParkingSlotById(@PathVariable Long id){

        ParkingSlotResponse response = parkingSlotService.getParkingSlotById(id);
        return ResponseEntity.ok(new ParkingSlotResponse());
    }

    @GetMapping
    public ResponseEntity<List<ParkingSlotResponse>> getAllParkingSlot(){

     List<ParkingSlotResponse> parkingSlots = parkingSlotService.getAllParkingSlot();
     return ResponseEntity.ok(parkingSlots);
    }

    @PutMapping("{id}")
    public ResponseEntity<ParkingSlotResponse> updateParkingSlot(@PathVariable Long id,@RequestBody UpdateParkingSlotRequest request){

        ParkingSlotResponse updatedSlot = parkingSlotService.updateParkingSlot(id,request);
        return ResponseEntity.ok(updatedSlot);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteParkingSlot(@PathVariable Long id){

        parkingSlotService.deleteParkingSlot(id);
        return ResponseEntity.noContent().build();
    }


}
