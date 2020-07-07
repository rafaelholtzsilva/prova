package br.com.entrevista.shoppingcart.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@FeignClient( name = "zuul-api-gateway-server")
@RibbonClient(name=CustomerServiceProxy.NAME_SERVICE)
public interface CustomerServiceProxy {

	static final String NAME_SERVICE = "customer-service";
	
	@RequestMapping(value = NAME_SERVICE + "/customers/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object find(@PathVariable("id") Long id);


}
