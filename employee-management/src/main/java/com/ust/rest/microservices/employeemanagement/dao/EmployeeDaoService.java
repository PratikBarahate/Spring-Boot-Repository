package com.ust.rest.microservices.employeemanagement.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.rest.microservices.employeemanagement.bean.Employee;

@Component
public class EmployeeDaoService {
	
	public Employee findOne(int id) {
		List<Employee> allEmployees = EmployeeDatabase.getEmployeeList();
		Predicate<Employee> predicate = employee -> employee.getEmployeeId().equals(id);
		return allEmployees.stream()
			.filter(predicate)
			.findFirst()
			.orElse(null);
	}
	
	public List<Employee> findAllEmployees(){
		return EmployeeDatabase.getEmployeeList();
	}

	public Employee saveEmployee(Employee employee) {
		Integer employeeCount = EmployeeDatabase.getEmployeeCount();
		employee.setEmployeeId(++employeeCount);
			
		EmployeeDatabase.getEmployeeList().add(employee);
		
		return employee;
	}

	public boolean deleteEmployee(int employeeId) {
		System.out.println("Id:"+employeeId);
		Predicate<? super Employee> predicate = employee -> employee.getEmployeeId().equals(employeeId);
		return EmployeeDatabase.getEmployeeList().removeIf(predicate);
			
			
	}
}
