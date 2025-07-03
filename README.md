# 🏢 Oracle-JDBC-EmployeeManagement

This is a Java console-based application that manages Employee and Department data using **JDBC (Java Database Connectivity)** and an **Oracle Database**. The project supports basic CRUD operations and includes a feature to calculate Provident Fund (PF) for employees based on their salary.

This project is ideal for beginners learning JDBC, database interactions, and DAO design pattern.

---

## 📌 Features

- Add new Department and Employee records
- Retrieve Employee details using their ID
- Calculate PF based on salary slabs
- Uses the DAO design pattern for clean architecture
- Utilizes Lombok to reduce boilerplate code

---

## 🛠️ Technologies Used

- Java 23
- JDBC (Java Database Connectivity)
- Oracle Database (SQL)
- Lombok (for annotations like @Builder, @Getter, etc.)
- IntelliJ IDEA (IDE)

---

## 🗃️ Database Tables

### 🔹 Department Table

| Column Name           | Data Type      | Constraints            |
|-----------------------|----------------|-------------------------|
| departmentId          | NUMBER         | Primary Key, NOT NULL  |
| departmentName        | VARCHAR2(100)  |                         |
| departmentHead        | VARCHAR2(100)  |                         |
| departmentDescription | VARCHAR2(255)  |                         |

### 🔹 Employee Table

| Column Name       | Data Type     | Constraints                     |
|-------------------|---------------|----------------------------------|
| employeeId        | NUMBER        | Primary Key                     |
| employeeName      | VARCHAR2(50)  |                                  |
| employeeSalary    | NUMBER(8,2)   |                                  |
| employeeAddress   | VARCHAR2(50)  |                                  |
| employeeContactNo | NUMBER        |                                  |
| departmentId      | NUMBER        | Foreign Key → Department table |

---

## 🧮 Provident Fund (PF) Calculation

The Provident Fund is calculated using the following salary slabs:

| Salary Range        | PF Percentage |
|---------------------|----------------|
| ₹1,000 – ₹10,000    | 5%             |
| ₹10,001 – ₹1,00,000 | 6%             |
| > ₹1,00,000         | 7%             |

---

## 📸 Screenshots
---
![image alt](https://github.com/Annwesha10/Oracle-JDBC-EmployeeManagement/blob/f7145993dfbecf5f210e57a44c15e09968d56b33/Screenshot%202025-07-03%20170813.png)
---
![image alt](https://github.com/Annwesha10/Oracle-JDBC-EmployeeManagement/blob/f7145993dfbecf5f210e57a44c15e09968d56b33/Screenshot%202025-07-03%20171125.png)
---
![image alt](https://github.com/Annwesha10/Oracle-JDBC-EmployeeManagement/blob/f7145993dfbecf5f210e57a44c15e09968d56b33/Screenshot%202025-07-03%20171146.png)
---
![image alt](https://github.com/Annwesha10/Oracle-JDBC-EmployeeManagement/blob/f7145993dfbecf5f210e57a44c15e09968d56b33/Screenshot%202025-07-03%20172001.png)

---

## 📧 Contact

Made with ❤️ by [Annwesha Naha]  
📧 Email: annweshanaha2005@gmail.com
🔗 GitHub: [Annwesha10](https://github.com/Annwesha10)
