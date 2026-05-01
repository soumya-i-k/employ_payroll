# Payroll Management System

A desktop-based **Payroll Management System** built using **Java Swing**, **JDBC**, and **MySQL**.
The application provides a graphical interface to manage employee salary records while following a structured layered architecture.

---

## Features

* Add employee payroll details through GUI
* View all employee records in a table (JTable)
* Update salary information *(backend ready)*
* Delete employee records by ID
* Basic input validation through service layer

---

## Tech Stack

* Java (Swing)
* JDBC
* MySQL
* SQL

---

## Project Structure

```id="pl1"
Payroll-Management-System/
│
├── src/
│   ├── dao/        → database interaction (JDBC)
│   ├── dto/        → employee payroll data model
│   ├── service/    → business logic & validation
│   ├── ui/         → Swing GUI
│   └── mysql-connector-j-9.x.x.jar
│
├── .gitignore
└── README.md
```

---

## Architecture Overview

The project follows a layered architecture to separate responsibilities:

* **DTO** – represents employee and salary data
* **DAO** – handles database operations using JDBC
* **Service** – manages validations and business rules
* **UI** – provides a graphical interface for user interaction

---

## Database Setup

```sql id="pl2"
CREATE DATABASE rnsitdb;
USE rnsitdb;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);
```

---

## Running the Project

1. Ensure MySQL server is running
2. Update database credentials in:

   ```
   dao/EmployeeDAOImpl.java
   ```
3. Compile the project:

   ```bash
   javac -d . -cp src/mysql-connector-j-9.x.x.jar src/*/*.java
   ```
4. Run the application:

   ```bash
   java -cp ".;src/mysql-connector-j-9.x.x.jar" ui.EmployeeUI
   ```

---

## Future Improvements

* Salary calculation module (bonuses, deductions)
* Search employees by name or department
* Advanced UI using layout managers
* Authentication system
* Export payroll reports

---

## What I Learned

* Applying layered architecture in Java applications
* Integrating Java Swing with MySQL using JDBC
* Managing structured employee data using SQL
* Building interactive desktop interfaces

---

## Author

Soumya Ishwar Kambar
