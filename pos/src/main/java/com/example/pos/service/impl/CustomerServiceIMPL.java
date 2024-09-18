package com.example.pos.service.impl;

import com.example.pos.dto.CustomerDTO;
import com.example.pos.dto.request.CustomerUpdateDTO;
import com.example.pos.entity.Customer;
import com.example.pos.repository.CustomerRepo;
import com.example.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
            customerRepo.save(customer);
        }else {
            throw new RuntimeException("no data found");
        }
        return customerUpdateDTO.getCustomerName()+"  updated successfull";
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        if(customerRepo.existsById(id)){
            Customer customer = customerRepo.getReferenceById(id);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;
        }
        else{
            throw new RuntimeException("No customer");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer>getAllCustomers = customerRepo.findAll();
        List<CustomerDTO>customerDTOList= new ArrayList<>();
        for (Customer customer:getAllCustomers) {
            CustomerDTO  customerDTO= new CustomerDTO(
               customer.getCustomerId(),
               customer.getCustomerName(),
               customer.getCustomerAddress(),
               customer.getContactNumber(),
               customer.getCustomerSalary(),
               customer.getNic(),
               customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
        }

    @Override
    public String deleteCustomer(int id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
            return "deleted successfully"+id;
        }else{
            throw new RuntimeException("no customer found in that id");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean status) {
        List<Customer>getAllCustomers = customerRepo.findAllByActiveEquals(status);

        List<CustomerDTO>customerDTOList= new ArrayList<>();
        for (Customer customer:getAllCustomers) {
            CustomerDTO  customerDTO= new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }


}


