package com.OnlineOjek.OnlineOjek.service;

import com.OnlineOjek.OnlineOjek.model.Booking;
import com.OnlineOjek.OnlineOjek.model.Customer;
import com.OnlineOjek.OnlineOjek.model.Driver;
import com.OnlineOjek.OnlineOjek.repository.BookingRepository;
import com.OnlineOjek.OnlineOjek.repository.CustomerRepository;
import com.OnlineOjek.OnlineOjek.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.*;
import java.awt.print.Book;
import java.util.List;


@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepo;

    @Autowired
    DriverRepository driverRepo;

    @Autowired
    CustomerRepository custRepo;

    @Autowired
    CustomerService customerService;

    @Autowired
    DriverService driverService;

    public Booking createBooking(Booking booking) {
        Customer cust = customerService.findCustomerById(booking.getCustomer().getId());
        Driver driver = driverService.findDriverById(booking.getDriver().getId());

        if (cust.getBalance() >= 5000 && driver.getStatus().equals("AVAILABLE")) {
            driver.setStatus("NOT_AVAILABLE");
            booking.setStatus("ACCEPTED");
            return bookingRepo.save(booking);
        } else {
            booking.setStatus("REJECTED");
        }
        return null;
    }

    public List<Booking> getAllBooking(){
        return bookingRepo.findAll();
    }

    public Booking getBooking(long id){
        return bookingRepo.findById(id).get();
    }

    @Transactional
    public Booking cancellBooking(Booking booking){
        Booking cancelBooking= bookingRepo.findById(booking.getId()).get();
        Driver driverCancel=driverService.findDriverById(booking.getDriver().getId());
        if(cancelBooking.getStatus().equals("ACCEPTED")) {
            cancelBooking.setStatus("CANCELLED");
            driverCancel.setStatus("AVAILABLE");
            driverRepo.save(driverCancel);
            return bookingRepo.save(cancelBooking);
        }
        return null;
    }

    @Transactional
    public Booking doneBooking(Booking booking){
        Booking doneBooking= bookingRepo.findById(booking.getId()).get();
        Driver driverDone=driverService.findDriverById(booking.getDriver().getId());
        Customer custDone=customerService.findCustomerById(booking.getCustomer().getId());
        if(doneBooking.getStatus().equals("ACCEPTED")){
            doneBooking.setStatus("DONE");
            driverDone.setStatus("AVAILABLE");
            custDone.setBalance(custDone.getBalance()-5000.00);
            driverDone.setBalance(driverDone.getBalance()+5000.00);
            custRepo.save(custDone);
            driverRepo.save(driverDone);
            return bookingRepo.save(doneBooking);
        }
        return null;
    }
}
