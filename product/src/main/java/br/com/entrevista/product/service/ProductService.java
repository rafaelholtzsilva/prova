package br.com.entrevista.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.entrevista.product.model.dao.entities.Product;
import br.com.entrevista.product.model.dao.impl.ProductDaoImpl;

@Service
@Transactional(readOnly = true)
public class ProductService {

	@Autowired
	@Qualifier("productDao")
	private ProductDaoImpl productDao;

	public List<Product> getAll() {
		return productDao.findAll();
	}

	public Product getById(Long id) {
		return productDao.find(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Product product) {
		productDao.create(product);
	}

	public boolean remove(Long id) {
		Optional<Product> p = productDao.find(id);
		if (p.isPresent()) {
			productDao.remove(p.get());
		}

		return p.isPresent();
	}
}