package br.com.entrevista.customer.model.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.entrevista.customer.entities.Customer;
import br.com.entrevista.customer.model.CustomerRepository;
import br.com.entrevista.customer.test.CustomerBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerRepositoryTest extends CustomerBaseTest {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void injectedComponentsAreNotNull() {
		Assert.assertNotNull(customerRepository);
	}

	@Test
	public void empty() {
		Assert.assertFalse(customerRepository.findById(1l).isEmpty());
	}

	@Test
	public void findById() {
		Optional<Customer> customer = customerRepository.findById(1l);
		log.info("customer is presente {} ", customer.isPresent());
		Assert.assertTrue(customer.isPresent());
		Assert.assertEquals(customer.get().getEmail(), "rholtzbr@gmail.com");
	}

	@Test
	public void findAll() {
		Iterable<Customer> customers = customerRepository.findAll();
		Assert.assertEquals(4, customers.spliterator().getExactSizeIfKnown());
	}

}