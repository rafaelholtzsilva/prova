package br.com.entrevista.product.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import br.com.entrevista.product.model.test.ProductRepositoryTest;


@RunWith(Suite.class)
@SuiteClasses(value ={
		ProductRepositoryTest.class
})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}
	
	@Test
	@Sql("classpath:product.sql")
	void getProductById() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/catalog/product/1001",
				String.class)).contains("Babador");
		
	}
	
}
