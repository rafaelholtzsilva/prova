package br.com.entrevista.shoppingcart.controller.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.entrevista.shoppingcart.controller.ShoppingCartController;
import br.com.entrevista.shoppingcart.test.ShoppingCartBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShoppingCartControllerTest extends ShoppingCartBaseTest {
	
	@Autowired
	private ShoppingCartController shoppingCartController;
	
	@Test
	public void setup() {
		log.info("shoppingCartController: class is notnull:  {}", shoppingCartController);
		Assert.assertNotNull(shoppingCartController);
	}

}
