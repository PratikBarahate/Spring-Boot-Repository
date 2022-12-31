package com.ust.rest.microservices.employeemanagement.versioning;

public class EmployeeV1 {
	private String name;

	public EmployeeV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeeV1 [name=" + name + "]";
	}

}
