package com.ust.rest.microservices.employeemanagement.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.rest.microservices.employeemanagement.bean.Employee;

public interface EmployeeSpringDataJpaRepository extends JpaRepository<Employee, Integer>{
	
}
