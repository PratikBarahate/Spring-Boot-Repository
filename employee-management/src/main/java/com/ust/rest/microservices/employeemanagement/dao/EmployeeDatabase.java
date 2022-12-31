package com.ust.rest.microservices.employeemanagement.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ust.rest.microservices.employeemanagement.bean.Employee;

public class EmployeeDatabase {
		
	private static List<Employee> employeeList = new ArrayList<>();
	private static Integer employeeCount = 1001;
	
	static {
		Employee e1 = new Employee(employeeCount, "Mahesh Kothari", LocalDate.now(), 12500.00);
		Employee e2 = new Employee(++employeeCount, "Aditya Chopra", LocalDate.now(), 60000.00);
		Employee e3 = new Employee(++employeeCount, "Mallika Sherawat", LocalDate.now(), 45135.00);
		Employee e4 = new Employee(++employeeCount, "Raju Hirani", LocalDate.now(), 456000.00);
		Employee e5 = new Employee(++employeeCount, "Vikram Bhatt", LocalDate.now(), 7899.00);
		Employee e6 = new Employee(++employeeCount, "Sanjay Bhansali", LocalDate.now(), 68520.00);
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
		employeeList.add(e6);
	}
	
	public static List<Employee> getEmployeeList() {
		return employeeList;
	}

	public static Integer getEmployeeCount() {
		return employeeCount;
	}
}
