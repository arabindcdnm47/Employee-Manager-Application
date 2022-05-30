package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	
	public List<Employee> findAll() {
		
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		if(result.isPresent()) {
			return result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - "+theId);
			
		}
	}

	@Override
	
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
