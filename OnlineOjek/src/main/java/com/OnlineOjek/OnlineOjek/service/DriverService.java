package com.OnlineOjek.OnlineOjek.service;

import com.OnlineOjek.OnlineOjek.model.Driver;
import com.OnlineOjek.OnlineOjek.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepo;

    public Driver addDriver(Driver driver){
        driver.setStatus("AVAILABLE");
        return driverRepo.save(driver);
    }

    public List<Driver> getAllDriver(){
        return driverRepo.findAll();
    }

    public Driver findDriverById(Long id){
        return driverRepo.findById(id).get();
    }
}
