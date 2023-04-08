package com.ust.com.Employee_registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.com.Employee_registration.model.Employee;
import com.ust.com.Employee_registration.service.EmployeeService;


@RestController
@RequestMapping("/registration")
@CrossOrigin("*")
public class EmployeeController {
	
    @Autowired
	private EmployeeService employeeService;
    
    @PostMapping("/addemps")
    public Employee addEmployee(@RequestBody Employee employee)
    {
		return employeeService.createEmployee(employee);
    	
    }
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(@RequestBody Employee employee) {
       return employeeService.getEmployees();
    }
    
    @GetMapping("/employee/{id}")
    public Employee getAllEmployeeById(@PathVariable int id) {
       return employeeService.getEmployeeById(id);
    }
    @PutMapping("/updateemployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
    	return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
    	return employeeService.deleteEmployeeById(id);
    }
}



