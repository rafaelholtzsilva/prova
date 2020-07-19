package br.com.entrevista.customer.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

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
	@Sql("classpath:customer.sql")
	void getCustomerById() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/customers/customer/1", String.class))
				.contains("rholtzbr@gmail.com");

	}

}
