package com.explore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "countries")
@Entity
public class Country {

    @Id
    @GeneratedValue
    private int id;

    private String name;
}