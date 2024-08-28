package com.example.pos.controller;

import com.example.pos.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin()
public class CustomerController {


    @PostMapping("/save-1")
    public String saveCustomer(){
        return "saved";
    }

    @PostMapping("/save-2")
    public String saveCustomerWith(@RequestBody CustomerDTO customerDTO){
        String message =customerDTO.getCustomerName();
        System.out.println("come"+message);
        return message;
    }

}
