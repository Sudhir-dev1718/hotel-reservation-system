package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hotel.model.Reservation;
import com.hotel.util.DBConnection;

public class ReservationDAO {

	public void createReservation(Reservation r) {
		String customerCheck = "SELECT * FROM customers WHERE id = ?";

	    String checkQuery = "SELECT * FROM reservations WHERE room_number = ? AND (check_in <= ? AND check_out >= ?)";

	    String insertQuery = "INSERT INTO reservations(customer_id, room_number, check_in, check_out) VALUES (?, ?, ?, ?)";

	    try (Connection con = DBConnection.getConnection()) {
	    	
	    	
	        PreparedStatement custPs = con.prepareStatement(customerCheck);
	        custPs.setInt(1, r.getCustomerId());
	        ResultSet custRs = custPs.executeQuery();
	        
	        if (!custRs.next()) {
	            System.out.println("Invalid Customer ID!");
	            return;
	        }


	        // 🔥 STEP 1: CHECK AVAILABILITY
	        PreparedStatement checkPs = con.prepareStatement(checkQuery);
	        checkPs.setInt(1, r.getRoomNumber());
	        checkPs.setString(2, r.getCheckOut());
	        checkPs.setString(3, r.getCheckIn());

	        ResultSet rs = checkPs.executeQuery();

	        if (rs.next()) {
	            System.out.println("Room already booked for given dates!");
	            return; // ❌ STOP here
	        }
	        
	        
	    
	        // 🔥 STEP 2: INSERT if available
	        PreparedStatement ps = con.prepareStatement(insertQuery);
	        ps.setInt(1, r.getCustomerId());
	        ps.setInt(2, r.getRoomNumber());
	        ps.setString(3, r.getCheckIn());
	        ps.setString(4, r.getCheckOut());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Reservation Created Successfully!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}