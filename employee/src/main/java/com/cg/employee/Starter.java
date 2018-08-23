package com.cg.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.employee.pojo.Employee;
import com.cg.employee.service.EmployeeServiceImpl;

@SpringBootApplication
public class Starter {

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);

	}
	
	
	@Bean
	public CommandLineRunner loadInitialData(EmployeeServiceImpl service)
	{
		return (args)->{
			service.addNewEmployee(new Employee(101,"rafa","clay"));
			service.addNewEmployee(new Employee(102,"roger","all rounder"));
			service.addNewEmployee(new Employee(103,"potro","hardcourt"));
			service.addNewEmployee(new Employee(104,"zverev","clay"));
			service.addNewEmployee(new Employee(105,"kevin","hardcourt"));
			service.addNewEmployee(new Employee(106,"cilic","hardcourt"));
			service.addNewEmployee(new Employee(107,"grigor","clay"));
			service.addNewEmployee(new Employee(108,"theim","clay"));
			service.addNewEmployee(new Employee(109,"david","grass"));
			
		};
	}

}
