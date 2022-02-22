package tum.seba.mobilityservices.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tum.seba.mobilityservices.entity.Employee;
import tum.seba.mobilityservices.service.EmployeeService;
import tum.seba.mobilityservices.service.RequestValidationService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RequestValidationService requestValidationService;

	@GetMapping("/employees")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<Iterable<Employee>>(employeeService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<?> findOne(@PathVariable int id) {
		return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/employees")
	public ResponseEntity<?> newEmployee(@Valid @RequestBody Employee newEmployee, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Employee>(employeeService.save(newEmployee), HttpStatus.CREATED);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<?> replaceEmployee(@PathVariable int id, @Valid @RequestBody Employee newEmployee, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		newEmployee.setId(id);
		employeeService.save(newEmployee);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		employeeService.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
