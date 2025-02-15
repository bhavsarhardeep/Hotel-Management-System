# **Hotel Management System 🏨**

A **Java-based Hotel Management System** built using **Swing, AWT**, and **SQL (JDBC)** for efficient hotel operations. The system enables administrators and reception staff to manage **rooms, customers, employees, bookings, and finances** seamlessly.

## **Features 🚀**
✔️ **User Authentication** – Secure login for admin and reception staff.  
✔️ **Room Management** – Add, update, search, and track room status.  
✔️ **Customer Management** – Register new customers, track check-ins, and handle payments.  
✔️ **Employee Management** – Add, update, and manage hotel staff.  
✔️ **Reception & Bookings** – Assign rooms, generate invoices, and handle check-outs.  
✔️ **Driver & Pickup Services** – Manage guest transportation and driver availability.  
✔️ **Database Integration** – Uses **SQL (JDBC)** to securely store and retrieve hotel data.  

## **Technologies Used 🛠️**
- **Programming Language:** Java  
- **GUI Frameworks:** Swing, AWT  
- **Database:** MySQL (via JDBC)  

## **Setup Instructions 🔧**
### **1. Clone the Repository**
```bash
 git clone https://github.com/bhavsarhardeep/Hotel-Management-System.git
```

### **2. Set Up MySQL Database**
- Open MySQL and create the database:
```sql
CREATE DATABASE hotel_management;
USE hotel_management;

CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE rooms (
    room_number INT PRIMARY KEY,
    availability VARCHAR(20),
    price DECIMAL(10,2),
    bed_type VARCHAR(20)
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    room_number INT,
    checkin_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deposit DECIMAL(10,2),
    FOREIGN KEY (room_number) REFERENCES rooms(room_number)
);

CREATE TABLE employees (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    job VARCHAR(50),
    salary DECIMAL(10,2)
);
```
- Update **JDBC connection settings** in the project accordingly.

### **3. Run the Application**
1. Open the project in your **Java IDE (Eclipse/IntelliJ IDEA)**.
2. Run `Login2.java` to launch the system.
3. Use the **Sign Up** feature to create an account.
4. Log in and access the dashboard to manage the hotel.

## **Screenshots 📸**
Add screenshots in the `screenshots/` folder and reference them in this section:
```markdown
![Login Screen](screenshots/login_screen.png)
![Dashboard](screenshots/dashboard.png)
![Room Management](screenshots/room_management.png)
```

## **License 📜**
This project is licensed under the **MIT License**.

---
