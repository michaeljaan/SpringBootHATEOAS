package com.cg.employee.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Employee {
	
	
	@Id
	private int empID;
	private String name;
	private String deptName;
	private List<Link> links =new ArrayList<>();
	
	
	
	
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Employee() {
		super();
		
	}
	public Employee(int empID, String name, String deptName) {
		super();
		this.empID = empID;
		this.name = name;
		this.deptName = deptName;
	}
	
	

}
