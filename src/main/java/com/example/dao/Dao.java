package com.example.dao;

import com.example.entity.Department;
import com.example.entity.Employee;

public interface Dao {
    boolean storeDepartmentDetails(Department department);
    boolean storeEmployeeDetails(Employee employee);
    Employee retrieveEmployeeDetails(Integer id);
    double calculatePF(Integer employeeId);
}
