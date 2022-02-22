package tum.seba.mobilityservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.Employee;
import tum.seba.mobilityservices.exception.EntityNotFoundException;
import tum.seba.mobilityservices.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}

	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee findById(int employeeId) {
		return employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee with ID '" + employeeId + "' does not exist!"));
	}

	public void deleteById(int employeeId) {
		
		try {
			employeeRepository.deleteById(employeeId);
		}
		catch (Exception e) {
			System.err.println("Unable to delete Employee with ID: " + employeeId);
		}
		
	}
}
