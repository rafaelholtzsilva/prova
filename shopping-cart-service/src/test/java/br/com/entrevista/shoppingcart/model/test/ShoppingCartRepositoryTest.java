package br.com.entrevista.shoppingcart.model.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.entrevista.shoppingcart.entities.ShoppingCart;
import br.com.entrevista.shoppingcart.entities.Status;
import br.com.entrevista.shoppingcart.model.ShoppingCartRepository;
import br.com.entrevista.shoppingcart.test.ShoppingCartBaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShoppingCartRepositoryTest extends ShoppingCartBaseTest {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Test
	void injected_components_are_not_null() {
		Assert.assertNotNull(shoppingCartRepository);
	}

	@Test
	public void load_file_sql_and_insert_find_by_id() {
		Assert.assertFalse(shoppingCartRepository.findById(1l).isEmpty());
	}

	@Test
	public void find_shopping_cart_by_id() {
		Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(1l);
		log.info("shoppingCartRepository is presente {} ", shoppingCart.isPresent());
		Assert.assertTrue(shoppingCart.isPresent());
		Assert.assertEquals(shoppingCart.get().getCustomerId(), Long.valueOf(20));
	}

	@Test
	public void find_all_shopping_cart() {
		Iterable<ShoppingCart> customers = shoppingCartRepository.findAll();
		Assert.assertEquals(5, customers.spliterator().getExactSizeIfKnown());
	}

	@Test
	public void find_current_shopping_cart_by_customer() {
		ShoppingCart shoppingCart = shoppingCartRepository.findCurrentShoppingCart(20l);
		Assert.assertEquals(shoppingCart.getStatus(), Status.INCOMPLETE);
		Assert.assertEquals(shoppingCart.getId(), (Long) 1l);
		Assert.assertEquals(shoppingCart.getCommerceItems().size(), 3);
	}
}