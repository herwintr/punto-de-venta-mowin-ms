/**
 * 
 */
package com.papeleria.del.istmo.mowin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**
	 * Variable con el titulo de la pantalla de swagger-ui
	 */
	@Value("${variable.swagger.titulo}")
	private String titulo;

	/**
	 * Variable con la descripcion de la pantalla de swagger-ui
	 */
	@Value("${variable.swagger.descripcion}")
	private String descripcion;
	
	/**
	 * Variable con la version de la pantalla de swagger-ui	
	 */
	@Value("${variable.swagger.version}")
	private String version;
	
	/**
	 * Variable con el nombre de la pantalla de swagger-ui
	 */
	@Value("${variable.swagger.nombre}")
	private String nombre;
	
	/**
	 * Variable con el correo de la pantalla de swagger-ui
	 */
	@Value("${variable.swagger.correo}")
	private String correo;
	
	/**
	 * Bean para scannear las APIs existentes en el proyecto
	 *  y generar el swagger-ui.
	 * @return docket con configuracion para scannar APIs.
	 */
	@Bean
	public Docket productApi() {
	  return new Docket(DocumentationType.SWAGGER_2)
			  .useDefaultResponseMessages(Boolean.FALSE)
			  .select()
			  .apis(RequestHandlerSelectors
			  .basePackage("com.papeleria.del.istmo.mowin"))
			  .paths(PathSelectors.any())
	      .build().apiInfo(apiInfo());
	}

	/**
	 * Builder para el ApiInfo.
	 * @return apiInfo con la informacion de la construccion del API.
	 */
	private ApiInfo apiInfo() {
	  return new ApiInfoBuilder()
			  .title(titulo)
			  .description(descripcion)
			  .version(version)
			  .contact(new Contact(nombre, " ", correo)).build();
	}
}
