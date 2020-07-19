package br.com.entrevista.shoppingcart.controller;

import javax.validation.constraints.NotEmpty;



import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient( name="zuul-api-gateway-server")
@RibbonClient(name=ProductServiceProxy.SERVICE_NAME)
public interface ProductServiceProxy {
	
	
	static final String SERVICE_NAME = "product-service";


	@RequestMapping(value = SERVICE_NAME  + "/catalog/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object find(@NotEmpty(message = "Requered Product id") @PathVariable("id") Long id);


}
