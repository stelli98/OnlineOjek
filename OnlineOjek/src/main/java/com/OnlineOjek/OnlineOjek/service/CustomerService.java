package com.OnlineOjek.OnlineOjek.service;

import com.OnlineOjek.OnlineOjek.model.Customer;
import com.OnlineOjek.OnlineOjek.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    @Autowired
    CustomerRepository custRepo;

    public Customer addCustomer(Customer customer){
        return custRepo.save(customer);
    }

    public List<Customer> getAllCustomer(){
        return custRepo.findAll();
    }

    public Customer findCustomerById(Long id){
        return custRepo.findById(id).get();
    }
}