package br.com.entrevista.customer.controller;

import java.util.Optional;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.entrevista.customer.entities.Customer;
import br.com.entrevista.customer.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("customers")
@Api(value="EndPoint to manager Customer" )
@Validated
@Slf4j
public class CustomerController {


	private static ResponseEntity<Void> STATUS_FORBIDDEN = new ResponseEntity<Void>(HttpStatus.FORBIDDEN);

	private static ResponseEntity<Void> STATUS_OK = new ResponseEntity<Void>(HttpStatus.OK);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "Hello";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<Void> test() {
		return STATUS_OK;
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Find and Get Customer by id", response= Customer.class)
	public @ResponseBody Customer find ( @PathVariable  @Positive(message = "min value 1") @NotNull(message = "Requered Customer id") Long id) {
		log.info("customer/{} ", id);	
		Optional<Customer> optional = customerService.getById(id);
		log.info("customer/{} ", id, optional);	
		
		if(optional.isPresent())	
			return optional.get();
		else			
			return null;
		
	}

	@RequestMapping(value = "/customer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void create(@NotEmpty(message = "Requered Product") @RequestBody Customer customer) {

		customerService.create(customer);
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
		Customer a = new Customer();
		a.setName("casa");
		a.setEmail("xx@gmail.com");
		a.setPassword("xxxxx");
		customerService.create(a);
	}

}
