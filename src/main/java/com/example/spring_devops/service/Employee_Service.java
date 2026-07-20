package com.example.spring_devops.service;

import java.util.List;
import java.util.Optional;

import com.example.spring_devops.models.Employee;


public interface Employee_Service {

	public List<Employee> getAllEmployee();
	
	public Optional<Employee> getEmoployeeById(int id);
	
	public Employee insertUser(Employee us);
	
	public void deletebyId(int id);
	
	public Employee updatedUser(Employee updatedUser,int id);
}
