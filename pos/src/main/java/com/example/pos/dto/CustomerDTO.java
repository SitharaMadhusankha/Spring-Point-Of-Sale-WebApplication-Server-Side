package com.example.pos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private String contactNumber;
    private double customerSalary;
    private String nic;
    private boolean active;






}
