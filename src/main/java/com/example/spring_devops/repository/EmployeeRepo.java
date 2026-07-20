package com.example.spring_devops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.example.spring_devops.models.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
