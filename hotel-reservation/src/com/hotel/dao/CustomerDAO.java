package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hotel.model.Customer;
import com.hotel.util.DBConnection;

public class CustomerDAO {

    public void addCustomer(Customer customer) {

        String query = "INSERT INTO customers(name, phone) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Added Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}