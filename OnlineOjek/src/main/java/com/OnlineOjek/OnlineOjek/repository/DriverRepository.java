package com.OnlineOjek.OnlineOjek.repository;

import com.OnlineOjek.OnlineOjek.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    List<Driver> findByStatus(String status);
}
