package br.com.entrevista.customer.model.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.Valid;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.validation.annotation.Validated;

@Entity(name = Customer.TABLE)
@Validated
@NamedQueries({
		@NamedQuery(name = "customer.byEmail", query = "Select c FROM br.com.entrevista.customer.model.dao.entities.Customer c WHERE c.email = :email") })
public class Customer {

	public Customer() {
		this.name = null;
		this.lastname = null;
		this.email = null;
		this.password = null;
	}

	public static final String TABLE = "CUSTOMERS";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LAST_NAME")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
