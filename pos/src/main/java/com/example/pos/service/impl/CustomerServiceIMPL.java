package com.example.pos.service.impl;

import com.example.pos.dto.CustomerDTO;
import com.example.pos.entity.Customer;
import com.example.pos.repository.CustomerRepo;
import com.example.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
            customerDTO.getCustomerId(),
            customerDTO.getCustomerName(),
            customerDTO.getCustomerAddress(),
            customerDTO.getContactNumber(),
            customerDTO.getCustomerSalary(),
            customerDTO.getNic(),
            customerDTO.isActive()
        );

        customerRepo.save(customer);
        return null;
    }
}
