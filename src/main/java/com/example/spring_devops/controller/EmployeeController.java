package com.example.spring_devops.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_devops.models.Employee;
import com.example.spring_devops.service.Employee_Service;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
    private Employee_Service us;
	
    @GetMapping
    public List<Employee> getAllUsers() {
    	return this.us.getAllEmployee();
   
    }
    
    @PostMapping
    public Employee insertUser(@ModelAttribute Employee newUser)
    {
    	this.us.insertUser(newUser);
    	return newUser;
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable int id) {

        Optional<Employee> found_User = this.us.getEmoployeeById(id);

        if(found_User.isPresent()) {
            return ResponseEntity.ok(found_User.get());
        }

        return ResponseEntity.notFound().build();
    }
    
    
   

    @DeleteMapping("/{id}")
    public void deletebyId(@PathVariable int id)
    {
    	this.us.deletebyId(id);
    	System.out.println("Item deleted");
    }
    
    @PutMapping
    public Employee updatedata( @ModelAttribute Employee updatedUser,int id)
    {
    Employee updatedUser2=	us.updatedUser(updatedUser, id);
    return updatedUser2;
    }
    

}
