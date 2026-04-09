package com.hotel.model;

public class Customer {

    private int id;
    private String name;
    private String phone;

    // Constructor (IMPORTANT)
    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters (VERY IMPORTANT)
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}