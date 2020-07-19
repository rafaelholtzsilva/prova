package br.com.entrevista.shoppingcart.controller;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.entrevista.shoppingcart.entities.CommerceItem;
import br.com.entrevista.shoppingcart.entities.ShoppingCart;
import br.com.entrevista.shoppingcart.service.ShoppingCartService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("shopping-carts")
@Validated
@Slf4j
@Getter
@Setter
public class ShoppingCartController {
	
	private static ResponseEntity<ShoppingCart> NOT_FOUND = new ResponseEntity<>(HttpStatus.NOT_FOUND);

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private ProductServiceProxy productServiceProxy;

	@Autowired
	private CustomerServiceProxy customerServiceProxy;

	@RequestMapping(value = "shopping-cart/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ShoppingCart> shoppingCart(Long id) {

		Optional<ShoppingCart> shoppingCart = shoppingCartService.findById(id);
		if(shoppingCart.isPresent()) {
			return new ResponseEntity<ShoppingCart>(shoppingCart.get(), HttpStatus.OK);
		}else {
			return  NOT_FOUND;
		}

	} 

	/*
	 * *
	 * 
	 * @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE,
	 * produces = "application/json") public @ResponseBody void
	 * deleteItem(@NotEmpty(message = "Requered Product id") @PathVariable String
	 * id, HttpServletRequest request) { log.info("delete commerceItem" + id);
	 * ShoppingCart shoppingCart = getShoppingCart(request);
	 * shoppingCartService.remove(shoppingCart, id); }
	 * 
	 * @RequestMapping(value = "/items", method = RequestMethod.POST, produces =
	 * "application/json") public @ResponseBody CommerceItem
	 * addRequestParam(@NotEmpty(message =
	 * "Requered Product id") @RequestParam(name="product_id",required=false) String
	 * id,
	 * 
	 * @Min(value = 1, message = "Min Quantity 1") @NotNull(message =
	 * "Requered Quantity") @RequestParam(name="quantity",required=false) Integer
	 * quantity, HttpServletRequest request) { log.info("add  product " + id +
	 * "quantity" + quantity);
	 * 
	 * Product product = productService.getById(id); CommerceItem commerceItem =
	 * null; if (product != null) { ShoppingCart shoppingCart =
	 * getShoppingCart(request); commerceItem =
	 * shoppingCartService.add(shoppingCart, product, quantity); } return
	 * commerceItem; }
	 * 
	 * @NotEmpty(message = "Requered Product id")
	 * 
	 * @Min(value = 1, message = "Min Quantity 1") @NotNull(message =
	 * "Requered Quantity")
	 */

	@RequestMapping(value = "/items/{id}/{quantity}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody CommerceItem add(@PathVariable Long id,
			@Min(value = 1, message = "Min Quantity 1") @PathVariable Integer quantity) {
		log.info("add  product {} quantity {}", id, quantity);
		Object product = productServiceProxy.find(id);
		Object customer = customerServiceProxy.find(id);

		CommerceItem c = new CommerceItem();
		c.setProductId(id);
		c.setQuantity(quantity);

		return c;
	}

	/*
	 * private ShoppingCart getShoppingCart(HttpServletRequest request) {
	 * ShoppingCart shoppingCart = (ShoppingCart)
	 * request.getSession().getAttribute(SHOPPING_CART_SESSION); if (shoppingCart ==
	 * null) { shoppingCart = shoppingCartService.create();
	 * request.getSession().setAttribute(SHOPPING_CART_SESSION, shoppingCart); }
	 * return shoppingCart; }
	 * 
	 * @ExceptionHandler(value = { ConstraintViolationException.class })
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	 * 
	 * @ResponseBody() public String
	 * handleResourceNotFoundException(ConstraintViolationException e) {
	 * Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
	 * StringBuilder strBuilder = new StringBuilder(); for (ConstraintViolation<?>
	 * violation : violations) { strBuilder.append(violation.getMessage() + "\n"); }
	 * return strBuilder.toString(); }
	 * 
	 */

}
