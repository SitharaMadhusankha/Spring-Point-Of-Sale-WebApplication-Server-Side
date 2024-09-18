package com.example.pos.dto.request;

import com.example.pos.entity.enums.MesuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemSaveRequestDTO {

    private String itemName;
    private MesuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplier;
    private double sellingPrice;



}
