package com.example.pos.service;

import com.example.pos.dto.CustomerDTO;
import com.example.pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();
}
