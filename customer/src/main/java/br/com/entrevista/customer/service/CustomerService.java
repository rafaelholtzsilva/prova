package br.com.entrevista.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.entrevista.customer.model.dao.entities.Customer;
import br.com.entrevista.customer.model.dao.impl.CustomerDaoImpl;

@Service()
@Transactional
public class CustomerService {

	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	@Qualifier("customerDao")
	private CustomerDaoImpl customerDao;

	public Customer getById(Long id) {
		return customerDao.find(id);
	}
	
	public Customer findByEmail(String email) {
		logger.debug("email: {}");
		return customerDao.findByEmail(email);
	}
		
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Customer customer) {
		customerDao.create(customer);
	}

}
