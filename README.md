# Hotel Reservation System (Console-Based)

## 📌 Description

This is a console-based hotel reservation system built using Java and JDBC.
It allows users to manage customers and book rooms while preventing duplicate reservations.

## 🚀 Features

* Add Customer
* Book Room
* Room Availability Check (prevents overlapping bookings)
* Customer ID Validation
* MySQL Database Integration

## 🛠️ Tech Stack

* Java (Core)
* JDBC
* MySQL

## ⚙️ How to Run

1. Clone the repository
2. Setup MySQL database (`hotel_db`)
3. Update DB credentials in `DBConnection.java`
4. Run `MainApp.java`

## 🧠 Key Logic

* Prevents double booking using date overlap logic
* Validates customer existence before reservation

## 📷 Sample Output

* Reservation Created Successfully
* Room already booked
* Invalid Customer ID
