package com.example;

import com.example.dao.Dao;
import com.example.dao.impl.DaoImpl;
import com.example.entity.Department;
import com.example.entity.Employee;

public class Main {
    public static void main(String[] args) {
    Dao dao = new DaoImpl();

        Department department = Department.builder().
                departmentId(1).
                departmentName("Accounts").
                departmentHead("Ramesh").
                departmentDescription("AccountsDept").
                build();
        System.out.println("Department details is stored in database");
        dao.storeDepartmentDetails(new Department(1, "Accounts", "Ramesh", "Account Dept"));
        dao.storeDepartmentDetails(new Department(2, "Admin", "Vijay", "Admin Dept"));
        dao.storeDepartmentDetails(new Department(3, "Sales", "Vinod", "Sales Dept"));
        dao.storeDepartmentDetails(new Department(4, "HR", "Mahesh", "HR Dept"));

        Employee employee = Employee.builder().
                employeeId(1).
                employeeName("Neel").
                employeeSalary(12000.00).
                employeeAddress("Kolkata").
                employeeContactNo(9878781212L).
                departmentId(2).
                build();
        dao.storeEmployeeDetails(new Employee(110, "Neel", 12000.0, "Kolkata",9878761212L , 2));
        dao.storeEmployeeDetails(new Employee(115, "Himanshi", 18000.0, "Bengaluru", 9654377643L, 1));
        dao.storeEmployeeDetails(new Employee(120, "Siddharth", 11000.0, "Mumbai", 9965322212L, 4));
        dao.storeEmployeeDetails(new Employee(125, "Tanya", 19000.0, "Chennai", 8078343732L, 3));
        dao.storeEmployeeDetails(new Employee(130, "Dhruv", 27000.0, "Noida", 9932113221L, 4));
        dao.storeEmployeeDetails(new Employee(135, "Anupama", 21000.0, "Gwalior", 7076337238L, 2));


        System.out.println("Employee details is stored in database");


        dao.calculatePF(120);

    }
}
