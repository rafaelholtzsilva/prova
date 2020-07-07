package br.com.entrevista.shoppingcart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shoppingCartService")
@Transactional(readOnly = true)
public class ShoppingCartService  {

	private static Logger log = LoggerFactory.getLogger(ShoppingCartService.class);
/*
	public ShoppingCart create() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setCommerceItems(new ArrayList<CommerceItem>());
		shoppingCart.setAmout(BigDecimal.ZERO);
		
		return shoppingCart;
	}

	@Override
	public CommerceItem add(ShoppingCart shoppingCart, Product product, Integer quantity) {
		
		log.info(" amount before  " +shoppingCart.getAmout() );
		CommerceItem commerceItem = null;
		commerceItem = getCommerceItem(shoppingCart, product.getId());
		if (commerceItem != null) {
			
			BigDecimal addAmout = product.getPrice().multiply(BigDecimal.valueOf(quantity));
			commerceItem.setAmount(commerceItem.getAmount().add(addAmout));
			shoppingCart.setAmout(shoppingCart.getAmout().add(addAmout));
			commerceItem.setQuantity(commerceItem.getQuantity() + quantity);
		} else {
			commerceItem = createCommerceItem();
			commerceItem.setProduct(product);
			commerceItem.setQuantity(quantity);
			commerceItem.setAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
			shoppingCart.getCommerceItems().add(commerceItem);
			shoppingCart.setAmout(shoppingCart.getAmout().add(commerceItem.getAmount()));
		}
		log.info(" amount after  " +shoppingCart.getAmout() );
		return commerceItem;

	}
	
	@Override
	public CommerceItem createCommerceItem(){
		return new CommerceItem(UUID.randomUUID().toString());
		
	}
	
	@Override
	public  CommerceItem getCommerceItem(ShoppingCart shoppingCart, String id){
		for (CommerceItem commerceItem : shoppingCart.getCommerceItems()) {
			if(commerceItem.getProduct().getId().equals(id)){
				return commerceItem;
			}
		}
		return null;
	}

	@Override
	public CommerceItem remove(ShoppingCart shoppingCart, String id) {
		CommerceItem remove = getCommerceItem(shoppingCart, id);
		if (remove != null) {
			shoppingCart.setAmout(shoppingCart.getAmout().subtract(remove.getAmount()));
			shoppingCart.getCommerceItems().remove(remove);
		}		
		return remove;
	}
	*/
}
