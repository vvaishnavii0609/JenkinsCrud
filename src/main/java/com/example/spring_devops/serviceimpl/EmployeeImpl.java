package com.example.spring_devops.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_devops.models.Employee;
import com.example.spring_devops.repository.EmployeeRepo;
import com.example.spring_devops.service.Employee_Service;


@Service
public class EmployeeImpl implements Employee_Service {
	
	@Autowired
	private EmployeeRepo repo;
	

private List<Employee> employees=new ArrayList<>();
	
//	public UserServiceImpl() {
//		this.users.add(new User(1,"ABC","aabc@gmail.com","xyz"));
//		this.users.add(new User(2,"LMN","lmn@gmail.com","abc"));
//	}
	


	@Override
	public List<Employee> getAllEmployee() {

		return this.repo.findAll();
	}


	@Override
	public Optional<Employee> getEmoployeeById(int id) {
	
				return repo.findById(id);
			
		}
	
	
	@Override
	public Employee insertUser(Employee newUser) {		
		
		Employee createdUserRepo = this.repo.save(newUser);

		return createdUserRepo;
	}


	@Override
	public void deletebyId(int id) {
		
			if(repo.existsById(id)) {
				repo.deleteById(id);
				System.out.println("User Id Deleted");
			}
			else {
				System.out.println("ID not Found");
			}
		
		
	}
	@Override
	public Employee updatedUser(Employee updatedUser, int id) {
		// TODO Auto-generated method stub
		Employee updatedUser2 =null;
		if(repo.existsById(id))
		{
			updatedUser2 = this.repo.save(updatedUser);
			
		}
		return updatedUser2;
	}
	
	

}
