package com.example.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
    @Table(name = "customer")
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class Customer {

        @Id
        @Column(name = "customer_id",length = 45)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int customerId;

        @Column(name = "customer_name", length = 100,nullable = false)
        private String customerName;

        @Column(name = "customer_address",length = 255)
        private String customerAddress;

        @Column(name = "contact_number",length = 15)
        private String contactNumber;

        @Column(name = "customer_Salary",length = 255)
        private double customerSalary;

        @Column(name = "nic")
        private String nic;

        @Column(name = "active_state",columnDefinition = "TINYINT default 1")
        private boolean active;


    }




