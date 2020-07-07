package br.com.entrevista.shoppingcart.model.dao.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;


@javax.persistence.Entity(name = ShoppingCart.TABLE)
public class ShoppingCart {

	
	public static final String TABLE = "SHOPPING_CARTS";
	
	@Id
	@Column(name = "ID")
	private String id;
	
//	private List<CommerceItem> commerceItems;
	
	@Transient
	private BigDecimal amout;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	/*
	 * public List<CommerceItem> getCommerceItems() { return commerceItems; }
	 * 
	 * public void setCommerceItems(List<CommerceItem> commerceItems) {
	 * this.commerceItems = commerceItems; }
	 */
	public BigDecimal getAmout() {
		return amout;
	}

	public void setAmout(BigDecimal amout) {
		this.amout = amout;
	}
	
}
