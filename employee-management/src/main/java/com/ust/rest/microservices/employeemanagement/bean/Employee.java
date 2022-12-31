package com.ust.rest.microservices.employeemanagement.bean;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

//@JsonIgnoreProperties({"employeeSalary", "employeeBirthDate"})
@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer employeeId;
	
	
	//@JsonProperty("name")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String employeeName;
	
	@Past(message = "Birth date should be in past")
	private LocalDate employeeBirthDate;
	
	//@JsonIgnore
	private Double employeeSalary;
	
	@OneToMany(mappedBy = "employee")
	@JsonIgnore
	private List<Project> projects;
	

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String employeeName, LocalDate employeeBirthDate, Double employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeBirthDate = employeeBirthDate;
		this.employeeSalary = employeeSalary;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public LocalDate getEmployeeBirthDate() {
		return employeeBirthDate;
	}

	public void setEmployeeBirthDate(LocalDate employeeBirthDate) {
		this.employeeBirthDate = employeeBirthDate;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeBirthDate="
				+ employeeBirthDate + ", employeeSalary=" + employeeSalary + "]";
	}

	
}
