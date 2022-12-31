package com.ust.rest.microservices.employeemanagement.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ust.rest.microservices.employeemanagement.bean.Employee;

@Component
public class EmployeeSpringJdbcRepository {
	
	private static String SELECT_QUERY = """
			select * from employee where employee_id=?
			""";
	
	private static String SELECT_ALL_QUERY = """
			select * from employee
			""";
	
	private static String INSERT_QUERY = """
			insert into employee (employee_id, employee_name, employee_birth_date, employee_salary)
			 values(?,?,?,?)
			""";
	
	private static String DELETE_QUERY = """
			delete from employee where employee_id = ?
			""";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employee findOne(int id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Employee.class), id);
	}
	
	public List<Employee> findAllEmployees(){
		return jdbcTemplate.query(SELECT_ALL_QUERY, new BeanPropertyRowMapper<>(Employee.class));
	}

	public void saveEmployee(Employee employee) {
		jdbcTemplate.update(INSERT_QUERY, employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeBirthDate(),
				employee.getEmployeeSalary());
	}

	public int deleteEmployee(int employeeId) {
		return jdbcTemplate.update(DELETE_QUERY, employeeId);
	}
}
