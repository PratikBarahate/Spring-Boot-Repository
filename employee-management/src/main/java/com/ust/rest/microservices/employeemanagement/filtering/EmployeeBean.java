package com.ust.rest.microservices.employeemanagement.filtering;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//Static & Dynamic Filtering
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"birthdate", "id"})
@JsonFilter("EmployeeBeanFilter")
public class EmployeeBean {
	
	private Long id;
	
	//@JsonProperty("Employee Name")
	private String name;
	
	//@JsonIgnore
	private LocalDate birthdate;

	public EmployeeBean(Long id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}

}
