package com.ust.rest.microservices.employeemanagement.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.rest.microservices.employeemanagement.bean.Project;

public interface ProjectSpringDataJpaRepository extends JpaRepository<Project, Integer>{
	
}
