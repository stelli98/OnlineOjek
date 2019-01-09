package com.OnlineOjek.OnlineOjek.repository;

import com.OnlineOjek.OnlineOjek.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByBalance(Double balance);
}
