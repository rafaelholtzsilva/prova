package br.com.entrevista.customer.test;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql("classpath:customer.sql")
public class CustomerBaseTest {

}
