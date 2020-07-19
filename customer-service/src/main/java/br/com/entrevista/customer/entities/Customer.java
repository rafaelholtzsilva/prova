package br.com.entrevista.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Entity(name = Customer.TABLE)
@Validated
@NamedQueries({
		@NamedQuery(name = "customer.byEmail", query = "Select c FROM br.com.entrevista.customer.entities.Customer c WHERE c.email = :email") })
@Getter
@Setter
public class Customer  {

	public Customer() {
		this.name = null;
		this.lastname = null;
		this.email = null;
		this.password = null;
	}

	public static final String TABLE = "CUSTOMERS";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
	@SequenceGenerator(name="customer_generator", sequenceName = "customer_seq")
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
	
}
