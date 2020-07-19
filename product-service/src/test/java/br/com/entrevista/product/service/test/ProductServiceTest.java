package br.com.entrevista.product.service.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.entrevista.product.entities.Product;
import br.com.entrevista.product.service.ProductService;
import br.com.entrevista.product.test.ProductBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductServiceTest extends ProductBaseTest {

	@Autowired
	ProductService productService;

	@Test
	public void setup() {
		log.info("productService: class is notnull:  {}", productService);
		Assert.assertNotNull(productService);
	}

	@Test
	public void find() {
		Optional<Product> optionalCustomer = productService.findById(1001l);
		log.info("find by id valid {} {} ", optionalCustomer.isPresent(), optionalCustomer);
		Assert.assertTrue(productService.findById(1001l).isPresent());
		Assert.assertFalse(productService.findById(93l).isPresent());
	}

}
