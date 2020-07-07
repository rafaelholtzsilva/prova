package br.com.entrevista.product.model.dao.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import br.com.entrevista.base.model.dao.AbstractDao;
import br.com.entrevista.product.model.dao.entities.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Product, Long> {

	public ProductDaoImpl() {
		super(Product.class);
	}

	public ProductDaoImpl(Class<Product> entityClass) {
		super(entityClass);
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void postConstructInit() {
		create(new Product("casa","http://www.terra.com.br",BigDecimal.valueOf(100)));
		create(new Product("Shampoo","http://www.test.com.br",BigDecimal.valueOf(104)));
	}


}
