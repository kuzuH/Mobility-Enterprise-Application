package tum.seba.mobilityservices.service;

import java.text.MessageFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.Employee;
import tum.seba.mobilityservices.repository.EmployeeRepository;
import tum.seba.mobilityservices.entity.Customer;
import tum.seba.mobilityservices.repository.CustomerRepository;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// check if the user can be found as an employee
		final Optional<Employee> optionalEmployee = employeeRepository.findByEmail(username);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		
		// if not, check if the user can be found as a customer
		final Optional<Customer> optionalCustomer = customerRepository.findByEmail(username);
		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		
		else {
			throw new UsernameNotFoundException(MessageFormat.format("User with username {0} cannot be found.", username));
		}
	
	}

}

