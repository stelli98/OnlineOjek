package com.OnlineOjek.OnlineOjek.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private  Long id;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Driver driver;

    private String status;
    private String location_to;
    private String location_from;
    private Double price=5000.00;
    private String payment;
}
