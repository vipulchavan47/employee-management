# Employee Management System

A simple and efficient application for managing employee details, built using Java and MySQL. The system supports CRUD operations.

---

---

## Technologies Used
- **Programming Language**: Java
- **Database**: MySQL
- **GUI Framework**: Java Swing (optional integration with JCalendar for date picking)


---

## Prerequisites
1. **Java Development Kit (JDK)** version 8 or later.
2. **MySQL** installed and running.
3. **Required Libraries**:
   - Download and add `mysql-connector-java`.
   - Download `JCalendar` if GUI-based date selection is needed.

---

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/employee-management-system.git
   ```

2. **Database Setup**:
   - Create a database named `EmployeeManagement`.
   - Execute the SQL script provided (`schema.sql`) to create tables.

3. **Configure Database Connection**:
   Update the database credentials in the code:
   ```java
   String url = "jdbc:mysql://localhost:3306/EmployeeManagement";
   String username = "your-username";
   String password = "your-password";
   ```

4. **Compile and Run the Application**:
   - Compile the Java files:
     ```bash
     javac Main.java
     ```
   - Run the application:
     ```bash
     java Main
     ```

---




