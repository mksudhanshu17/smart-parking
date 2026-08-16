package com.system.smartparking.parkinglot.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UpdateParkingLotRequest {

    private String name;

    private String location;

    @Min(1)
    private Integer totalFloors;
}
