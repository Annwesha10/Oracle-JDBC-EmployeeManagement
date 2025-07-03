package com.example.dao.impl;

import com.example.config.Utility;
import com.example.dao.Dao;
import com.example.entity.Department;
import com.example.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImpl implements Dao {
    @Override
    public boolean storeDepartmentDetails(Department department) {
        boolean status = false;
        try (Connection con = Utility.makeCon()) {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("INSERT INTO Department VALUES (?, ?, ?, ?)");
            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());
            ps.setString(3, department.getDepartmentHead());
            ps.setString(4, department.getDepartmentDescription());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                con.commit();
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException e) {
            System.out.println("Could not insert department details: " + e.getMessage());
        }
        return status;
    }

    @Override
    public boolean storeEmployeeDetails(Employee employee) {
        boolean status = false;
        try (Connection con = Utility.makeCon()) {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getEmployeeName());
            ps.setDouble(3, employee.getEmployeeSalary());
            ps.setString(4, employee.getEmployeeAddress());
            ps.setLong(5, employee.getEmployeeContactNo());
            ps.setInt(6, employee.getDepartmentId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                con.commit();
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException ee) {
            System.out.println("Could not insert employee details: " + ee.getMessage());
        }
        return status;
    }

    @Override
    public Employee retrieveEmployeeDetails(Integer id) {
        Employee emp = null;
        try (Connection con = Utility.makeCon()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee WHERE employeeId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new Employee(rs.getInt("employeeId"),
                        rs.getString("employeeName"),
                        rs.getDouble("employeeSalary"),
                        rs.getString("employeeAddress"),
                        rs.getLong("employeeContactNo"),
                        rs.getInt("departmentId")
                );
                System.out.println("Employee details: " + emp);
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException eee) {
            System.out.println("Could not retrieve employee details: " + eee.getMessage());
        }
        return emp;
    }

    @Override
    public double calculatePF(Integer employeeId) {
        double pfAmount = 0.0;
        try (Connection con = Utility.makeCon();
             PreparedStatement ps = con.prepareStatement("SELECT employeeName, employeeSalary FROM Employee WHERE employeeId = ?")) {
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double salary = rs.getDouble("employeeSalary");
                String name = rs.getString("employeeName");

                // PF Calculation Logic
                if (salary >= 1000 && salary <= 10000) {
                    pfAmount = salary * 0.05; // 5%
                } else if (salary > 10000 && salary <= 100000) {
                    pfAmount = salary * 0.06; // 6%
                } else if (salary > 100000) {
                    pfAmount = salary * 0.07; // 7%
                }

                System.out.println("PF Amount for " + name + " (ID: " + employeeId + "): " + pfAmount);
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error calculating PF: " + e.getMessage());
        }
        return pfAmount;    }
}
