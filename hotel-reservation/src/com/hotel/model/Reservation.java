package com.hotel.model;

public class Reservation {

    private int customerId;
    private int roomNumber;
    private String checkIn;
    private String checkOut;

    public Reservation(int customerId, int roomNumber, String checkIn, String checkOut) {
        this.customerId = customerId;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }
}