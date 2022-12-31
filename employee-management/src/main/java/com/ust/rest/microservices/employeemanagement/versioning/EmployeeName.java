package com.ust.rest.microservices.employeemanagement.versioning;

public class EmployeeName {
	private String firstName;
	private String lastName;

	public EmployeeName(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeName [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
