package br.com.entrevista.shoppingcart.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = ShoppingCart.TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShoppingCart {

	public ShoppingCart(Long customerId) {
		this.customerId = null;
		this.amout = BigDecimal.ZERO;
	}

	public static final String TABLE = "SHOPPING_CARTS";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHOPPING_CART_GENERATOR")
	@SequenceGenerator(name = "SHOPPING_CART_GENERATOR", sequenceName = "SHOPPING_CART_SEQ")
	@Column(name = "ID")
	private Long id;

	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@OneToMany(mappedBy = "shoppingCart")
	private List<CommerceItem> commerceItems;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;

	@Transient
	private BigDecimal amout;

}
