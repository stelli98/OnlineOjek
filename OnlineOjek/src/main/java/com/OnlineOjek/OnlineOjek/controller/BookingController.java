package com.OnlineOjek.OnlineOjek.controller;

import com.OnlineOjek.OnlineOjek.model.Booking;
import com.OnlineOjek.OnlineOjek.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/booking/add")
    public Booking createBooking(@RequestBody  Booking booking){
        return bookingService.createBooking(booking);
    }

    @PutMapping("/booking/{booking_id}/status/{status_name}")
    public Booking changeBookingStatus(@PathVariable("booking_id") Long booking_id, @PathVariable("status_name") String status_name, @RequestBody Booking booking){
        if(status_name.equals("CANCELLED")){
            return bookingService.cancellBooking(booking);
        }else if(status_name.equals("DONE")){
            return bookingService.doneBooking(booking);
        }
        return null;
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @GetMapping("/booking/{booking_id}")
    public Booking getBooking(@PathVariable ("booking_id") Long booking_id){
        return  bookingService.getBooking(booking_id);
    }

}
