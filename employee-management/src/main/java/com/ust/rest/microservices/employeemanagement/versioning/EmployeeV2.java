package com.ust.rest.microservices.employeemanagement.versioning;

public class EmployeeV2 {
	private EmployeeName name;

	public EmployeeV2(EmployeeName name) {
		super();
		this.name = name;
	}

	public EmployeeName getName() {
		return name;
	}

	public void setName(EmployeeName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeeV2 [name=" + name + "]";
	}
}
