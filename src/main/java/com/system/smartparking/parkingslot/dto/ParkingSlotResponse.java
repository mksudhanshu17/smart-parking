package com.system.smartparking.parkingslot.dto;

import com.system.smartparking.parkingslot.entity.SlotStatus;
import com.system.smartparking.parkingslot.entity.SlotType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class ParkingSlotResponse {

    private Long id;

    private String slotNumber;

    private SlotType slotType;

    private SlotStatus slotStatus;

    private BigDecimal perHourPrice ;

    private Integer floor;

    private Long parkingLotId;
}
