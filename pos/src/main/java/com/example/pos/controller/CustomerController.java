package com.example.pos.controller;

import com.example.pos.dto.CustomerDTO;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin()
public class CustomerController {


    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){

       return "save";
    }



}
