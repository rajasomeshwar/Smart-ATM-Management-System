# Smart ATM Management System

## 📌 Overview
The **Smart ATM Management System** is a Java-based application that simulates an ATM, allowing users to perform various banking operations like deposits, withdrawals, and balance inquiries. It is designed to enhance **user experience, security, and efficiency** in banking transactions.

### 👨‍💻 Team Members
- **Rajasomeshwar** (Team Lead)
- **Justin Aravind**
- **Mrudhula Suresh**

---

## 🔹 Features
✅ **User Authentication** – Secure login for customers using account credentials.  
✅ **Balance Inquiry** – Allows users to check their account balance.  
✅ **Cash Withdrawal & Deposit** – Users can withdraw and deposit cash securely.  
✅ **Mini Statement Generation** – Displays the last few transactions.  
✅ **Account Creation** – New users can create accounts directly through the system.  
✅ **Error Handling & Security** – Prevents invalid transactions using exception handling.  

---

## 🛠 Technologies Used
- **Programming Language:** Java  
- **Database:** MySQL (JDBC for database connectivity)  
- **GUI Framework:** Java Swing (if applicable)  
- **Concepts Used:**  
  - Classes and Objects  
  - Inheritance  
  - Exception Handling  
  - JDBC (Java Database Connectivity)  
  - Conditional Statements  

---

## 📜 Installation & Setup
### 🔹 Prerequisites
- Java Development Kit (**JDK 8+**)  
- MySQL Database  
- Apache NetBeans / Eclipse (Recommended IDE)  
- MySQL Connector for Java (`mysql-connector-j-8.0.32.jar`)  

### 🔹 Steps to Run the Project
1️⃣ **Clone the repository**  
```bash
git clone https://github.com/rajasomeshwar/Smart-ATM-Management-System.git
cd Smart-ATM-Management-System
```
2️⃣ **Set up the database**  
- Open MySQL and create a database:  
```sql
CREATE DATABASE atm_system;
USE atm_system;
```
- Import the provided SQL file or manually create tables.  

3️⃣ **Compile and Run the Project**  
```bash
javac main.java  
java main
```

---

## 📌 System Flow & Functionalities
1️⃣ **User logs into the ATM system using account credentials.**  
2️⃣ **Performs transactions like checking balance, withdrawal, or deposit.**  
3️⃣ **If an error occurs (e.g., insufficient funds), exception handling is triggered.**  
4️⃣ **Transaction details are stored in MySQL for future reference.**  

---

## 📂 Project Structure
```
📁 Smart-ATM-Management-System/
│-- 📂 javaproject_Banking/      # Contains all Java source files
│-- 📜 main.java                 # Entry point of the project
│-- 📜 CreateAccnt.java          # Handles account creation
│-- 📜 display.java              # Manages display screens
│-- 📜 runer.java                # Executes various functions
│-- 📜 taskcustomer.java         # Handles customer interactions
│-- 📜 mysql-connector-j-8.0.32.jar # MySQL JDBC Driver
│-- 📜 README.md                 # Documentation
```

---

## 🛠 Sample Code (Database Connection)
```java
import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm_system", "root", "password");
            System.out.println("Database Connected Successfully!");
        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
        }
    }
}
```

---

## 📊 Future Enhancements
🚀 **Biometric Authentication** – Adding fingerprint or facial recognition.  
🚀 **Mobile Banking Integration** – Syncing with mobile banking apps.  
🚀 **Multi-Bank Support** – Allowing transactions across multiple banks.  
🚀 **Enhanced Security** – Implementing two-factor authentication (2FA).  

---

## 📜 License
This project is open-source and available for learning purposes.  

## 📞 Contact & More Details
🔗 More project details: [Google Drive](https://drive.google.com/drive/u/0/folders/1bIRdAtbM63cP2s3dI566lKcduFMC5bbg)  

---
**📌 If you found this useful, give it a ⭐ on GitHub!** 🚀

