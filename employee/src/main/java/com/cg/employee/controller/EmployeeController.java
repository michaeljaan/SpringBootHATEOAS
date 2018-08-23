package com.cg.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employee.pojo.Employee;
import com.cg.employee.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	
	@RequestMapping("/employee")
	public List<Employee> viewAllEmployee()
	{
		return service.viewAllEmployee();
	}
	
	@RequestMapping("/employee/{id}")
	public Optional<Employee> getID(@PathVariable int id)
	{
		return service.getID(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employee")
	public void addNewEmployee(@RequestBody Employee employee)
	{
		service.addNewEmployee(employee);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/employee/{id}")
	public void updateEmployee(@PathVariable int id,@RequestBody Employee employee)
	{
		service.updateEmployee(id, employee);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/employee/{id}")
	public void deleteEmp(@PathVariable int id)
	{
		service.deleteEmp(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employee/{start}/{count}")
	public Resources<List<Employee>> getIdbyPage(@PathVariable int start, @PathVariable int count)
	{
		List<Employee> tempEmployee= service.viewAllEmployee();
		List<Employee> employee=new ArrayList<>();
		//Resources<List<Employee>> resources=null;
		for(int i=start;i<start+count;i++)
		{
			employee.add(tempEmployee.get(i));
		}
		
		Link nextLink = linkTo(methodOn(this.getClass()).getIdbyPage(start+count)).withRel("Next Link");
		Link previousLink = linkTo(methodOn(this.getClass()).getIdbyPage(start+count>=100?start-count:101)).withRel("Prevoius Link");
		
		
		return new Resources(employee,nextLink,previousLink);
	}

}
