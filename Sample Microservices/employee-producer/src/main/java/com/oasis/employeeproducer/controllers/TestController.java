package com.oasis.employeeproducer.controllers;

import com.oasis.employeeproducer.models.Employee;
import com.oasis.employeeproducer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "employee")
public class TestController {


	@Autowired
	private EmployeeRepository employeeRepository;



	@PostMapping("/add")
	public ResponseEntity<Employee> add(@RequestBody Employee employee){

		Employee newEmployee = new Employee();
		newEmployee.setDesignation(employee.getDesignation());
		newEmployee.setUsername(employee.getUsername());
		newEmployee.setName(employee.getName());
		newEmployee.setSalary(employee.getSalary());

		employeeRepository.save(newEmployee);

		return new ResponseEntity<>(newEmployee, HttpStatus.ACCEPTED);
	}


	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> all() {

		List<Employee> employees = employeeRepository.findAll();

		return new ResponseEntity<>(employees, HttpStatus.ACCEPTED);
	}


	@GetMapping("/{username}")
	public ResponseEntity<Employee> findStaff(@PathVariable ("username") String username){

		Employee employee = employeeRepository.findByUsername(username);

		return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
	}
	
}
