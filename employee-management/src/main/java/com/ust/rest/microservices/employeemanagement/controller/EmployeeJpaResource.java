package com.ust.rest.microservices.employeemanagement.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ust.rest.microservices.employeemanagement.bean.Employee;
import com.ust.rest.microservices.employeemanagement.error.EmployeeNotFoundException;
import com.ust.rest.microservices.employeemanagement.jpa.EmployeeJpaRepository;

@RestController
public class EmployeeJpaResource {
	
	@Autowired
	private EmployeeJpaRepository employeeRepository;

	@GetMapping("/employees/jpa")
	public List<Employee> retrieveAllEmployees() {
		return employeeRepository.findAllEmployees();
	}

	@GetMapping("/employees/jpa/{id}")
	public EntityModel<Employee> retrieveEmployee(@PathVariable int id) {
		Employee employee = employeeRepository.findOne(id);
		if (employee == null)
			throw new EmployeeNotFoundException("id:" + id);
		
		EntityModel<Employee> entityModel = EntityModel.of(employee);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllEmployees());
		entityModel.add(link.withRel("all-employees"));
		return entityModel;
	}

	@PostMapping("/employees/jpa")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeRepository.saveEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getEmployeeId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("employees/jpa/{id}")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable(name = "id") int employeeId) {
		
		employeeRepository.deleteEmployee(employeeId);
		
//		if(deleteEmployee!=1)
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(employeeId, HttpStatus.OK);
	}
}
