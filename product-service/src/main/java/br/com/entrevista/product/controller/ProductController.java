package br.com.entrevista.product.controller;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.entrevista.product.entities.Product;
import br.com.entrevista.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RestController
@RequestMapping("catalog")
@Slf4j
public class ProductController {

	private static ResponseEntity<Void> STATUS_FORBIDDEN = new ResponseEntity<Void>(HttpStatus.FORBIDDEN);

	private static ResponseEntity<Void> NOT_FOUND = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	private static ResponseEntity<Void> STATUS_OK = new ResponseEntity<Void>(HttpStatus.OK);

	@Autowired()
	private ProductService productService;

	@Autowired
	private Environment env;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "Hello" + env.getProperty("test.config");
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product find(@NotEmpty(message = "Requered Product id") @PathVariable Long id) {
		return productService.findById(id).get();
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody ResponseEntity<Void> delete(@NotEmpty(message = "Requered Product id") @PathVariable Long id) {
		boolean removed = productService.remove(id);
		return removed ? STATUS_OK : NOT_FOUND;
	}

	@RequestMapping(value = "/product", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody void create(@NotEmpty(message = "Requered Product") @RequestBody Product product) {
		productService.create(product);
	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody()
	public String handleResourceNotFoundException(ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		StringBuilder strBuilder = new StringBuilder();
		for (ConstraintViolation<?> violation : violations) {
			strBuilder.append(violation.getMessage() + "\n");
		}
		return strBuilder.toString();
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void load() {
		log.info("load product ");
		Product a = new Product();
		a.setName("casa");
		a.setPrice(new BigDecimal(100));
		a.setUrl("http://www.google.com.br");
		productService.create(a);
	}

}
