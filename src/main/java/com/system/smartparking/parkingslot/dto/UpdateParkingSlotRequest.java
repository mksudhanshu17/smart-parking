package com.system.smartparking.parkingslot.dto;

import com.system.smartparking.parkingslot.entity.SlotStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class UpdateParkingSlotRequest {

    private SlotStatus slotStatus;
    private BigDecimal perHourPrice;
}
