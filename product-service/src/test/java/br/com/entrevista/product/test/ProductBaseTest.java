package br.com.entrevista.product.test;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql("classpath:product.sql")
public abstract class ProductBaseTest {

}
