package com.example.springrestapi.controller;

import com.example.springrestapi.model.Employee;
import com.example.springrestapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController{

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployess();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,
                                                   @PathVariable("id") Long id){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Delete Success", HttpStatus.OK);
    }
}
