package br.com.entrevista.customer.model;

import org.springframework.data.repository.CrudRepository;

import br.com.entrevista.customer.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findByEmail(String email);

}
