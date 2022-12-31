package com.ust.rest.microservices.employeemanagement.controller;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.microservices.employeemanagement.bean.HelloWorldBean;

@RestController
public class HelloController {
	
	@Autowired
	private MessageSource messageSource;
	
	//RequestMapping
//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
	
	//GetMapping
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World Get Mapping";
	}
	
	//Returning Bean
	@GetMapping("hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	//Path Variable
	@GetMapping("hello-world-bean/{name}")
	public HelloWorldBean getHelloWorldBeanPathVariable(@PathVariable String name) {
		System.out.println("Name:"+name);
		return new HelloWorldBean(name);
	}
	
	//RequestParam
	@GetMapping("hello-user")
	public String helloWorldBeanRequestParam(@RequestParam String name) {
		return "Hello Dear User, "+name; 
	}
	
	//RequestParam -> variable name
	@GetMapping("hello-user-variablename")
	public String helloWorldBeanRequestParamVariableName(@RequestParam(name = "name") String userName) {
		return "Hello Dear User, "+userName; 
	}
	
	//RequestParam -> required = false -> null
	@GetMapping("hello-user-required")
	public String helloWorldBeanRequestParamRequired(@RequestParam(required = false) String name) {
		return "Hello Dear User, "+name; 
	}
	
	//RequestParam -> Optional -> any message
	@GetMapping("hello-user-optional")
	public String helloWorldBeanRequestParamOptional(@RequestParam Optional<String> name) {
		return "Hello Dear User, "+name.orElse("not provided"); 
	}
	
	//RequestParam -> defaultValue -> any message
	@GetMapping("hello-user-default")
	public String helloWorldBeanRequestParamDefault(@RequestParam(defaultValue = "notPresent") String name) {
		return "Hello Dear User, "+name;
	}
	
	
	//Note: name, required=false, optional all works same way for path variable.
	

	@GetMapping("hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		String message = messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		return message;
	}
}
