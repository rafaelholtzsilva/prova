package br.com.entrevista.customer.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.entrevista.base.model.dao.AbstractDao;
import br.com.entrevista.customer.model.dao.entities.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Customer, Long> {

	public CustomerDaoImpl() {
		super(Customer.class);
	}

	public CustomerDaoImpl(Class<Customer> entityClass) {
		super(entityClass);
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Customer findByEmail(String email) {
		Query query = getEntityManager().createNamedQuery("customer.byEmail");
		query.setParameter("email", email);
		return (Customer)query.getSingleResult();
	}

}
