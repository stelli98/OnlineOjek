package com.OnlineOjek.OnlineOjek.repository;

import com.OnlineOjek.OnlineOjek.model.Booking;
import com.OnlineOjek.OnlineOjek.model.Customer;
import com.OnlineOjek.OnlineOjek.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
