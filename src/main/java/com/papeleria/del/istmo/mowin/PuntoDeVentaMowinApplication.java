package com.papeleria.del.istmo.mowin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class PuntoDeVentaMowinApplication {
	/**
	 * Variable LOGGER de tipo Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PuntoDeVentaMowinApplication.class.getName());
	

	public static void main(String[] args) {
		SpringApplication.run(PuntoDeVentaMowinApplication.class, args);
		LOGGER.info("Arranque del servicio correcto");
	}


	/**
	 * Se define una fuente de mensajes
	 * de donde se obtendra los datos que
	 * se requieren para hacer uso de los
	 * mensajes
	 * @return Archivo YAML con la informacion
	 * que se usara para generar los mensajes
	 */
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	     
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	/**
	 * Bean de validacion de mensajes que se
	 * usaran en solicitudes HTTP de Spring
	 * @return Objeto de validacion que se
	 * maneja de manera interna para efectuar
	 * la obtencion de mensajes
	 */
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}
}
