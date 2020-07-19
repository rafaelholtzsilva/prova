package br.com.entrevista.customer.service.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.entrevista.customer.entities.Customer;
import br.com.entrevista.customer.service.CustomerService;
import br.com.entrevista.customer.test.CustomerBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerServiceTest extends CustomerBaseTest {

	@Autowired
	CustomerService customerService;

	@Test
	public void setup() {
		log.info("customerService: class is notnull:  {}", customerService);
		Assert.assertNotNull(customerService);
	}

	@Test
	public void find() {
		try {
			Optional<Customer> optionalCustomer = customerService.getById(1l);
			log.info("find by id valid {} {} ", optionalCustomer.isPresent(), optionalCustomer);
			Assert.assertTrue(customerService.getById(1l).isPresent());
			Assert.assertFalse(customerService.getById(93l).isPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findByEmail() {
		String email = "rholtzbr@gmail.com";

		Assert.assertNotNull(email);

		Customer customer = customerService.findByEmail(email);
		Assert.assertNotNull(customer);
		Assert.assertEquals(email, customer.getEmail());

		customer = customerService.findByEmail(email.toUpperCase());
		Assert.assertNull(customer);
	}

}
