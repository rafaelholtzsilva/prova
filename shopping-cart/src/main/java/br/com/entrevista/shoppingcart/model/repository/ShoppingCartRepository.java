package br.com.entrevista.shoppingcart.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.entrevista.shoppingcart.model.dao.entities.ShoppingCart;

@Repository  interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	
	ShoppingCart findByCurrentOrder(String customerId);
}
