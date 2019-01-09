package com.OnlineOjek.OnlineOjek.controller;

import com.OnlineOjek.OnlineOjek.model.Customer;
import com.OnlineOjek.OnlineOjek.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping ("/customer/add")
    public Customer createCustomer(@RequestBody Customer customer) {
       return customerService.addCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return  customerService.getAllCustomer();
    }

    @GetMapping("/customer/{cust_id}")
    public Customer getCustomer(@PathVariable("cust_id") Long cust_id) {
        return customerService.findCustomerById(cust_id);
    }
}