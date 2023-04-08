package com.ust.com.Employee_registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.com.Employee_registration.model.Employee;
import com.ust.com.Employee_registration.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;

	public Employee createEmployee(Employee employee) {
	
		return repo.save(employee);
			
	}
	
	public List <Employee> getEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee oldemp=null;
		Optional<Employee>optionalemployee=repo.findById(employee.getId());
		if(optionalemployee.isPresent()) {
			oldemp=optionalemployee.get();
			oldemp.setName(employee.getName());
			oldemp.setEmail(employee.getEmail());
			oldemp.setExperience(employee.getExperience());
			repo.save(oldemp);
		}
		else {
			return new Employee(0, null, null, 0, null);
		}
		return oldemp;
	}

	public String deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "the employee information is deleted";


}
}
