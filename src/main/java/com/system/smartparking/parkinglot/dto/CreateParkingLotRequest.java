package com.system.smartparking.parkinglot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateParkingLotRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotNull
    @Min(1)
    private Integer totalFloors;
}
