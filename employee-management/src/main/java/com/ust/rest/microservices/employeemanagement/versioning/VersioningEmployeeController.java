package com.ust.rest.microservices.employeemanagement.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VersioningEmployeeController {
	
	//URI Versioning
	@GetMapping("/v1/employee")
	public EmployeeV1 getFirstVersionOfEmployee() {
		return new EmployeeV1("Pratik Barahate");
	}
	
	@GetMapping("/v2/employee")
	public EmployeeV2 getSecondVersionOfEmployee() {
		return new EmployeeV2(new EmployeeName("Pratik", "Barahate"));
	}
	
	//Request Parameter Versioning
	@GetMapping(path = "employee", params = "version=1")
	public EmployeeV1 getFirstVersionOfEmployeeRequestParam() {
		return new EmployeeV1("Pratik Barahate");
	}
	
	@GetMapping(path = "/employee", params = "version=2")
	public EmployeeV2 getSecondVersionOfEmployeeRequestParam() {
		return new EmployeeV2(new EmployeeName("Pratik", "Barahate"));
	}
	
	//Request Header Versioning
	@GetMapping(path = "employee", headers = "X-API-VERSION=1")
	public EmployeeV1 getFirstVersionOfEmployeeRequestHeader() {
		return new EmployeeV1("Pratik Barahate");
	}
	
	@GetMapping(path = "/employee", headers = "X-API-VERSION=2")
	public EmployeeV2 getSecondVersionOfEmployeeRequestHeader() {
		return new EmployeeV2(new EmployeeName("Pratik", "Barahate"));
	}
	
	//Media Type Versioning
	@GetMapping(path = "employee", produces = "application/vnd.company.app-v1+json")
	public EmployeeV1 getFirstVersionOfEmployeeMediaType() {
		return new EmployeeV1("Pratik Barahate");
	}

	@GetMapping(path = "/employee", produces = "application/vnd.company.app-v2+json")
	public EmployeeV2 getSecondVersionOfEmployeeMediaType() {
		return new EmployeeV2(new EmployeeName("Pratik", "Barahate"));
	}
}
