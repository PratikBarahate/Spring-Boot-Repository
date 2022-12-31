package com.ust.rest.microservices.employeemanagement.jpa;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.ust.rest.microservices.employeemanagement.bean.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Employee findOne(int id) {
		return entityManager.find(Employee.class, id);
	}
	
	public List<Employee> findAllEmployees(){
		
		System.out.println("poooooooooooooooooooooooo");
		return entityManager.createQuery("from Employee").getResultList();
	}

	public Employee saveEmployee(Employee employee) {
		return entityManager.merge(employee);
	}

	public void deleteEmployee(int employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		entityManager.remove(employee);
	}
}
