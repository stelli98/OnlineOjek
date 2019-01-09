package com.OnlineOjek.OnlineOjek.controller;

import com.OnlineOjek.OnlineOjek.model.Driver;
import com.OnlineOjek.OnlineOjek.repository.DriverRepository;
import com.OnlineOjek.OnlineOjek.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("/driver/add")
    public Driver createDriver(@RequestBody  Driver driver){
        return driverService.addDriver(driver);
    }

    @GetMapping("/drivers")
    public List<Driver> getAllDriver(){
        return driverService.getAllDriver();
    }

    @GetMapping("/driver/{driver_id}")
    public Driver getDriver(@PathVariable ("driver_id") Long driver_id){
        return  driverService.findDriverById(driver_id);
    }
}
