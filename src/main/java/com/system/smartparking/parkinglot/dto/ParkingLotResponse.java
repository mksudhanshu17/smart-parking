package com.system.smartparking.parkinglot.dto;

import com.system.smartparking.parkinglot.entity.ParkingLotStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParkingLotResponse {
    private Long id;
    private String name;
    private String location;
    private Integer totalFloors;
    private ParkingLotStatus status;

}
