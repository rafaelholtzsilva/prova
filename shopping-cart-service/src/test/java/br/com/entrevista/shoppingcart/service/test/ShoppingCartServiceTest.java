package br.com.entrevista.shoppingcart.service.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.entrevista.shoppingcart.entities.ShoppingCart;
import br.com.entrevista.shoppingcart.service.ShoppingCartService;
import br.com.entrevista.shoppingcart.test.ShoppingCartBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShoppingCartServiceTest extends ShoppingCartBaseTest {

	@Autowired
	ShoppingCartService shoppingCartService;

	@Test
	public void setup() {
		log.info("shoppingCartService: class is notnull:  {}", shoppingCartService);
		Assert.assertNotNull(shoppingCartService);
	}

	@Test
	public void findCurrentOrder() {
		Optional<ShoppingCart> optionalCustomer = shoppingCartService.findCurrentShoppingCart(1001l);
		log.info("find current order by customer  {} ", optionalCustomer.isPresent(), optionalCustomer);
		Assert.assertTrue(shoppingCartService.findCurrentShoppingCart(1001l).isPresent());
		Assert.assertFalse(shoppingCartService.findCurrentShoppingCart(93l).isPresent());
	}

}
