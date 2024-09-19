package com.example.pos.dto.respones;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponesDTO {


    private int itemId;
    private String itemName;
    private double balanceQty;
    private double supplier;
    private double sellingPrice;
    private boolean activeState;



}
