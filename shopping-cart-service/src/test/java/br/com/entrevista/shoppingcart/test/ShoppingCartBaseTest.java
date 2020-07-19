package br.com.entrevista.shoppingcart.test;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import br.com.entrevista.shoppingcart.controller.CustomerServiceProxy;
import br.com.entrevista.shoppingcart.controller.ProductServiceProxy;

@DataJpaTest
@Sql(scripts = {"classpath:shopping-cart.sql","classpath:commerce-item.sql"})
public abstract class ShoppingCartBaseTest {
	
    @MockBean
    ProductServiceProxy productServiceProxy;

    @MockBean
    public CustomerServiceProxy customerServiceProxy ;

}
