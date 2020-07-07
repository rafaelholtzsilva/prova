package br.com.entrevista.shoppingcart.model.dao.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

@javax.persistence.Entity(name = CommerceItem.TABLE)
public class CommerceItem {

	public static final String TABLE = "COMMERCE_ITEM";

	public CommerceItem() {
	}

	public CommerceItem(String id) {
		super();
		this.id = id;
	}

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Transient
	private BigDecimal amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
