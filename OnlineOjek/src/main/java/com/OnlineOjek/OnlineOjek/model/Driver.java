package com.OnlineOjek.OnlineOjek.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driver_id")
    private Long id;
    private Double balance;
    private String name;
    private String status="AVAILABLE";
}
