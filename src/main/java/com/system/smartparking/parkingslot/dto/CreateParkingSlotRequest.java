package com.system.smartparking.parkingslot.dto;
import com.system.smartparking.parkingslot.entity.SlotType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class CreateParkingSlotRequest {

    @NotBlank
    private String slotNumber; // for example A01,B02

    @NotNull //why notBlank cuz slotType is enum not a String we use NotNull for objects and enums
    private SlotType slotType; //enum cuz it can be a bike,car ,ev ,etc

    @NotNull
    @DecimalMin(value = "0.0",inclusive = false)
    private BigDecimal perHourPrice ; // why not use double?cuz double sometimes can produce
    //values like 120.9999999 so we always use bigdecimal for money

    @NotNull
    @Min(0)
    private Integer floor; // example 0,1,2,3

    private Long parkingLotId;

}
