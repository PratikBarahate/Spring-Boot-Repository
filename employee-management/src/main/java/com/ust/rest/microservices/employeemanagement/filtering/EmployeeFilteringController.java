package com.ust.rest.microservices.employeemanagement.filtering;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class EmployeeFilteringController {
	
	private MappingJacksonValue mappingJacksonValue = null;
	private FilterProvider filterProviders = null;
	private SimpleBeanPropertyFilter filter = null;
	
	
	@GetMapping("filtering")//id, name
	public MappingJacksonValue filtering() {
		EmployeeBean bean = new EmployeeBean(1001L, "Ramesh Kumar", LocalDate.now());
		
		mappingJacksonValue = new MappingJacksonValue(bean);
		
		filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
		filterProviders = new SimpleFilterProvider().addFilter("EmployeeBeanFilter", filter);
		mappingJacksonValue.setFilters(filterProviders);
		
		return mappingJacksonValue;
		//return new EmployeeBean(1001L, "Ramesh Kumar", LocalDate.now());
	}
	
	@GetMapping("filtering-list")//name, birthDate
	public MappingJacksonValue filteringList(){
		List<EmployeeBean> list = Arrays.asList(new EmployeeBean(1001L, "Ramesh Kumar", LocalDate.now()),
				new EmployeeBean(1002L, "Vikay Babu", LocalDate.now()),
				new EmployeeBean(1003L, "Sarita Devi", LocalDate.now()));
		
		mappingJacksonValue = new MappingJacksonValue(list);
		filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "birthdate");
		filterProviders = new SimpleFilterProvider().addFilter("EmployeeBeanFilter", filter);
		mappingJacksonValue.setFilters(filterProviders);
		
		return mappingJacksonValue;
		
//		return Arrays.asList(new EmployeeBean(1001L, "Ramesh Kumar", LocalDate.now()),
//				new EmployeeBean(1002L, "Vikay Babu", LocalDate.now()),
//				new EmployeeBean(1003L, "Sarita Devi", LocalDate.now()));
	}
}
