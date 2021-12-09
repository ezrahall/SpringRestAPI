package com.example.springrestapi.service;

import com.example.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployess();
    Employee getEmployee(Long id);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);
}
