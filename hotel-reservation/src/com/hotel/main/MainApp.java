package com.hotel.main;

import java.util.Scanner;

import com.hotel.dao.CustomerDAO;
import com.hotel.dao.ReservationDAO;
import com.hotel.model.Customer;
import com.hotel.model.Reservation;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CustomerDAO customerDAO = new CustomerDAO();
        ReservationDAO reservationDAO = new ReservationDAO();

        while (true) {

            System.out.println("\n1.Add Customer  2.Book Room  3.Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    customerDAO.addCustomer(new Customer(name, phone));
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();

                    System.out.print("Enter Room Number: ");
                    int room = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Check-in (YYYY-MM-DD): ");
                    String in = sc.nextLine();

                    System.out.print("Check-out (YYYY-MM-DD): ");
                    String out = sc.nextLine();

                    reservationDAO.createReservation(
                            new Reservation(cid, room, in, out)
                    );
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}