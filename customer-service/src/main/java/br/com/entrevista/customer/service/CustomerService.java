package br.com.entrevista.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.entrevista.customer.entities.Customer;
import br.com.entrevista.customer.model.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Service()
@Transactional
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Optional<Customer> getById(Long id) {
		return customerRepository.findById(id);
	}
	
	public Customer findByEmail(String email) {
		log.debug("email: {}",email);
		return customerRepository.findByEmail(email);
	}
		
	@Transactional(propagation = Propagation.REQUIRED)
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

}
