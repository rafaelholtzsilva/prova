package br.com.entrevista.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.entrevista.base.test.model.TransactionTestConfiguration;
import br.com.entrevista.customer.model.dao.entities.Customer;
import br.com.entrevista.customer.service.CustomerService;

@ContextConfiguration(classes = { TransactionTestConfiguration.class })
public class CustomerServiceTest extends AbstractTransactionalTestNGSpringContextTests {

	@Override
	@BeforeSuite
	protected void springTestContextPrepareTestInstance() throws Exception {
		super.springTestContextPrepareTestInstance();
	}

	@BeforeTest
	public void setup() {
		System.out.println("*********************" + customerService);
		Assert.assertNotNull(customerService);
	}

	@Autowired
	CustomerService customerService;

	@Test
	public void find() {
		Assert.assertNotNull(customerService.getById(1l));
		Assert.assertNull(customerService.getById(93l));
	}

	@Test
	public void findByEmail() {
		String email = "rholtzbr@gmail.com";
		Customer customer = customerService.findByEmail(email);
		Assert.assertNotNull(customer);
		Assert.assertEquals(email, customer.getEmail());
		
//		customer = customerService.findByEmail(email.toUpperCase());		
//		Assert.assertNull(customer);		
	}



}
