package com.ust.studentmanagement.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.studentmanagement.model.HelloWorldBean;

@RestController
@RequestMapping(path = "test")
public class TestController {
	
	//Request Mapping
//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//	public String helloWorld() {
//		return "Hello World !";
//	}
	
	//@GetMapping
	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello World...!";
	}
	
	//Returning Bean
	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	//@PathVariable
	@GetMapping(path = "hello-world-bean/{message}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String message) {
		return new HelloWorldBean("Hello, "+message);
	}
	
	//@RequestParam
	@GetMapping(path = "hello-user")
	public String helloUserRequestParam(@RequestParam String name) {
		return "Hello Dear User, " + name;		
	}
	
	//@RequestParam --> Variable name
	@GetMapping(path = "hello-user-variablename")
	public String helloUserRequestParamVariableName(@RequestParam(name = "name") String userName) {
		return "Hello user, " + userName;
	}
	
	//@RequestParam --> required=false --> null
	@GetMapping(path = "hello-user-required")
	public String helloUserRequestParamRequired(@RequestParam(required = false) String name) {
		return "Hello user, "+ name;
	}
	
	//@RequestParam --> Optional --> Any Message
	@GetMapping(path = "hello-user-optional")
	public String helloUserRequestParamOptional(@RequestParam Optional<String> name) {
		return "Hello user, " + name.orElse("Username not provided");
	}
	
	@GetMapping(path = "hello-user-defaultvalue")
	public String helloUserRequestParamDefaultValue(@RequestParam(defaultValue = "not present") String name) {
		return "Hello user, " + name;
	}
	
	//
}
