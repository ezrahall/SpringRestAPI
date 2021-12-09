package com.example.springrestapi.service.impl;

import com.example.springrestapi.exception.ResourceNotFoundException;
import com.example.springrestapi.model.Employee;
import com.example.springrestapi.repository.EmployeeRepository;
import com.example.springrestapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployess() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        if(employeeRepository.existsById(id)){
            employee.setId(id);
            return employeeRepository.save(employee);
        }else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }
}
