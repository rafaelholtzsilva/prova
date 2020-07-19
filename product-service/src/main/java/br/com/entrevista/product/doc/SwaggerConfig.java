package br.com.entrevista.product.doc;

import org.springframework.context.annotation.Configuration;

import br.com.entrevista.base.doc.BaseSwaggerConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

	public SwaggerConfig() {
		super("br.com.entrevista.controller");
	}
}