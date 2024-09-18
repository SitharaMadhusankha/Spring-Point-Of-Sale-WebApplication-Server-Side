package com.example.pos.entity;

import jakarta.persistence.*;

@Entity
@Table(name="item")
public class Item {

    @Id
    @Column(name="item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name="item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name="measure_type",length = 100)
    private MesuringUnitType measuringUnitType;




}
