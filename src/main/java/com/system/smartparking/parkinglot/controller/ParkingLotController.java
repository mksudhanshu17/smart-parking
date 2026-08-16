package com.system.smartparking.parkinglot.controller;

import com.system.smartparking.parkinglot.dto.CreateParkingLotRequest;
import com.system.smartparking.parkinglot.dto.ParkingLotResponse;
import com.system.smartparking.parkinglot.dto.UpdateParkingLotRequest;
import com.system.smartparking.parkinglot.service.ParkingLotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parking-lots")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    @PostMapping
    public ResponseEntity<ParkingLotResponse> createParkingLot(@Valid  @RequestBody CreateParkingLotRequest request){
       ParkingLotResponse response = parkingLotService.createParkingLot(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingLotResponse> getParkingLotById(@PathVariable Long id){
       ParkingLotResponse response = parkingLotService.getParkingLotById(id);
       return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingLotResponse>> getAllParkingLots (){
        List<ParkingLotResponse> response = parkingLotService.getAllParkingLots();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingLotResponse> updateParkingLot (@PathVariable Long id, @Valid @RequestBody UpdateParkingLotRequest request){
        ParkingLotResponse response = parkingLotService.updateParkingLot(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingLot (@PathVariable Long id){
        parkingLotService.deleteParkingLot(id);
        return ResponseEntity.noContent().build();
    }
}
