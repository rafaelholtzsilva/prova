package br.com.entrevista.shoppingcart.model;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.entrevista.shoppingcart.entities.ShoppingCart;
import br.com.entrevista.shoppingcart.entities.Status;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	
	@Query("select DISTINCT sc from br.com.entrevista.shoppingcart.entities.ShoppingCart sc "
			+ "JOIN sc.commerceItems "
			+ "where sc.customerId= :customerId and sc.status = br.com.entrevista.shoppingcart.entities.Status.INCOMPLETE")
	ShoppingCart findCurrentShoppingCart(@Param("customerId")Long customerId);
	
	Collection<ShoppingCart> findByStatusAndCustomerId(Long customerId, @Param("customerId")Status status);
}
