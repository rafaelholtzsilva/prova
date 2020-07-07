package br.com.entrevista.product.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.entrevista.base.test.model.TransactionTestConfiguration;
import br.com.entrevista.base.test.service.AbstractServiceTestNGSpringContextTests;
import br.com.entrevista.product.service.ProductService;

@ContextConfiguration(classes = { TransactionTestConfiguration.class })
public class ProductServiceTest extends AbstractServiceTestNGSpringContextTests {

	@Override
	@BeforeSuite
	protected void springTestContextPrepareTestInstance() throws Exception {
		super.springTestContextPrepareTestInstance();
	}

	@BeforeTest
	public void setup() {
		Assert.assertNotNull(productService);
	}

	@Autowired
	ProductService productService;

	@Test
	public void work() {
		Assert.assertNotNull(productService);
	}

	@Test
	public void getAll() {
		Assert.assertEquals(productService.getAll().size(), 3);
	}

	@Test
	public void find() {
		Assert.assertNotNull(productService.getById(1001l));
		Assert.assertNull(productService.getById(93l));
	}

}
