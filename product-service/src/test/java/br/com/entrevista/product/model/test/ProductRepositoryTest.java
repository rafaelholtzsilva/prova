package br.com.entrevista.product.model.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.entrevista.product.entities.Product;
import br.com.entrevista.product.model.ProductRepository;
import br.com.entrevista.product.test.ProductBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductRepositoryTest extends ProductBaseTest {

	@Autowired
	ProductRepository productRepository;

	@Test
	void injectedComponentsAreNotNull() {
		Assert.assertNotNull(productRepository);
	}

	@Test
	public void empty() {
		Assert.assertFalse(productRepository.findById(1001l).isEmpty());
	}

	@Test
	public void findById() {
		Optional<Product> customer = productRepository.findById(1001l);
		log.info("customer is presente {} ", customer.isPresent());
		Assert.assertTrue(customer.isPresent());
		Assert.assertEquals(customer.get().getName(),"Babador");
	}

	@Test
	public void findAll() {
		Iterable<Product> customers = productRepository.findAll();
		Assert.assertEquals(3, customers.spliterator().getExactSizeIfKnown());
	}

}