package br.com.entrevista.product.model;

import org.springframework.data.repository.CrudRepository;

import br.com.entrevista.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
//	@EventListener(ApplicationReadyEvent.class)
//	@Transactional
//	public void postConstructInit() {
//		create(new Product("casa","http://www.terra.com.br",BigDecimal.valueOf(100)));
//		create(new Product("Shampoo","http://www.test.com.br",BigDecimal.valueOf(104)));
//	}


}
