package com.ust.rest.microservices.employeemanagement.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
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
import com.ust.rest.microservices.employeemanagement.bean.Project;
import com.ust.rest.microservices.employeemanagement.dao.EmployeeDaoService;
import com.ust.rest.microservices.employeemanagement.error.EmployeeNotFoundException;
import com.ust.rest.microservices.employeemanagement.error.ProjectNotFoundException;
import com.ust.rest.microservices.employeemanagement.jpa.EmployeeSpringDataJpaRepository;
import com.ust.rest.microservices.employeemanagement.jpa.ProjectSpringDataJpaRepository;

import jakarta.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDaoService employeeDaoService;
	
	@Autowired
	private EmployeeSpringDataJpaRepository employeeRepository;
	
	@Autowired
	private ProjectSpringDataJpaRepository projectRepository;

	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		//return employeeDaoService.findAllEmployees();
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public EntityModel<Employee> retrieveEmployee(@PathVariable int id) {
		//Employee employee = employeeDaoService.findOne(id);
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isEmpty())
			throw new EmployeeNotFoundException("id:" + id);
		
		EntityModel<Employee> entityModel = EntityModel.of(employee.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllEmployees());
		entityModel.add(link.withRel("all-employees"));
		return entityModel;
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		//Employee savedEmployee = employeeDaoService.saveEmployee(employee);
		Employee savedEmployee = employeeRepository.save(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getEmployeeId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("employees/{id}")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable(name = "id") int employeeId) {
//		boolean deleteStatus = employeeDaoService.deleteEmployee(employeeId);
		
//		if (!deleteStatus)
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<>(employeeId, HttpStatus.OK);
		
		employeeRepository.deleteById(employeeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//---------------Project Rest API's
	
	//get list of projects for employee id
	@GetMapping("/jpa/employees/{id}/projects")
	public List<Project> retrieveAllProjectsOfUser(@PathVariable int id){
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isEmpty())
			throw new EmployeeNotFoundException("id:" + id);
		
		return employee.get().getProjects();
	}
	
	//create project for employee id
	@PostMapping("/jpa/employees/{id}/projects")
	public ResponseEntity<Employee> createProjectForEmployee(@RequestBody Project project, @PathVariable(name="id") int employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		
		if(employee.isEmpty())
			throw new EmployeeNotFoundException("id:"+employeeId);

		project.setEmployee(employee.get());
		Project savedProject = projectRepository.save(project);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedProject.getProjectId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	//get project of id for employee with id
	@GetMapping("/jpa/employees/{employeeId}/projects/{projectId}")
	public Project retrieveProjectForEmployeeByProjectId(@PathVariable int employeeId, 
			@PathVariable int projectId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		
		if(employee.isEmpty())
			throw new EmployeeNotFoundException("id:"+employeeId);
		
		List<Project> projects = employee.get().getProjects();
		
		Project project = projectRepository.findById(projectId).get();
		if(!projects.contains(project))
			throw new ProjectNotFoundException("Project With Given Id Not Found For Given User Id:"+projectId);
			
		return project;
		
	}
	
}
