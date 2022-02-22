package tum.seba.mobilityservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.Customer;
import tum.seba.mobilityservices.exception.EntityNotFoundException;
import tum.seba.mobilityservices.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}

	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(int customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer with ID '" + customerId + "' does not exist!"));
	}

	public void deleteById(int customerId) {
		
		try {
			customerRepository.deleteById(customerId);
		}
		catch (Exception e) {
			System.err.println("Unable to delete Customer with ID: " + customerId);
		}
		
	}

	public Iterable<Customer> findCustomerWithUnpaidInvoices() {
		return customerRepository.findCustomersWithUnpaidInvoices();
	}

}
