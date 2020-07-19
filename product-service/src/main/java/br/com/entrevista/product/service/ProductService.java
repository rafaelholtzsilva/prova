package br.com.entrevista.product.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.entrevista.product.entities.Product;
import br.com.entrevista.product.model.ProductRepository;

@Service
@Transactional(readOnly = true)
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Iterable<Product> getAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Product create(Product product) {
		return productRepository.save(product);
	}

	public boolean remove(Long id) {
		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent()) {
			productRepository.delete(p.get());
		}
		return p.isPresent();
	}
}