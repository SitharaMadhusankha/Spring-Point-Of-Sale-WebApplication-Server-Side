package com.example.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerUpdateDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;




}
