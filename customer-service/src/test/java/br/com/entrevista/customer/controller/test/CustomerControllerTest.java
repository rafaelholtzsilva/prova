package br.com.entrevista.customer.controller.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import br.com.entrevista.customer.controller.CustomerController;
import br.com.entrevista.customer.test.CustomerBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerControllerTest extends CustomerBaseTest {

	@Autowired
	private CustomerController customerController;

	@Test
	public void setup() {
		log.info("customerController: class is notnull:  {}", customerController);
		Assert.assertNotNull(customerController);
	}


}
