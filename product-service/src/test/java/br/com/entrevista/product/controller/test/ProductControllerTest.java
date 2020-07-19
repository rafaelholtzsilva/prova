package br.com.entrevista.product.controller.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.entrevista.product.controller.ProductController;
import br.com.entrevista.product.test.ProductBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductControllerTest extends ProductBaseTest {

	@Autowired
	private ProductController customerController;

	@Test
	public void setup() {
		log.info("customerController: class is notnull:  {}", customerController);
		Assert.assertNotNull(customerController);
	}

}
