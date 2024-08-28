package com.example.pos.controller;

import com.example.pos.dto.CustomerDTO;


import com.example.pos.dto.request.CustomerUpdateDTO;
import com.example.pos.service.CustomerService;
import com.example.pos.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin()
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        System.out.println(customerDTO.getCustomerAddress());
       return customerDTO.getCustomerName();
    }
    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        customerService.updateCustomer(customerUpdateDTO);
    return "updated";
    }




}
