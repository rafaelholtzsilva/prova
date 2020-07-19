package br.com.entrevista.shoppingcart.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = CommerceItem.TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommerceItem {

	public static final String TABLE = "COMMERCE_ITEMS";

	public CommerceItem(String id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMERCE_ITEM_GENERATOR")
	@SequenceGenerator(name = "COMMERCE_ITEM_GENERATOR", sequenceName = "COMMERCE_ITEM_SEQ")
	@Column(name = "ID")
	private String id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SHOPPIN_CART_ID", nullable=false)
    private ShoppingCart shoppingCart;
    
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;

	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity;
	
	@Column(name = "UNIT_PRICE", nullable = false)
	private BigDecimal unitPrice;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

}
