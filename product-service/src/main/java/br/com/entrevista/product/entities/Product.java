package br.com.entrevista.product.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@javax.persistence.Entity(name = Product.TABLE)
@Getter
@Setter
public class Product {

	public Product() {
		this.name = null;
		this.url = null;
		this.price = null;		
	}

	public Product(String name, String url, BigDecimal price) {
		super();
		this.name = name;
		this.url = url;
		this.price = price;
	}

	public static final String TABLE= "PRODUCTS";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name="product_generator", sequenceName = "product_seq" )
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "URL")
	private String url;
	
	@Column(name = "PRICE")
	private BigDecimal price;
}
