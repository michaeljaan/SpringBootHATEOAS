package com.cg.employee.service;

import java.util.List;
import java.util.Optional;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Service;

import com.cg.employee.dao.EmployeeDAO;
import com.cg.employee.pojo.Employee;


@XmlRootElement
@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao;

	
	
	public void addNewEmployee(Employee employee)
	{
		dao.save(employee);
	}
	
	public List<Employee> viewAllEmployee()
	{
		return dao.findAll();
	}
	
	public Optional<Employee> getID(int id)
	{
		return dao.findById(id);
	}
	public void updateEmployee(int id, Employee employee)
	{
		dao.save(employee);
	}
	public void deleteEmp(int id) {
		dao.deleteById(id);
	}
	
	
}
