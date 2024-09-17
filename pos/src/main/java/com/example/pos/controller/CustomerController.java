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

    @PostMapping(
            path="/save"
    )
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        System.out.println(customerDTO.getCustomerAddress());
       return customerDTO.getCustomerName();
    }
    @PutMapping(path=
            "/update"
    )
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message=customerService.updateCustomer(customerUpdateDTO);

    return message;
    }

    @GetMapping(
            path="/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(int id){
        CustomerDTO customerDTO= customerService.getCustomerById(id);
        return customerDTO;
    }



}
