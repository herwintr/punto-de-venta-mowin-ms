/**
 * 
 */
package com.papeleria.del.istmo.mowin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.papeleria.del.istmo.mowin.util.ErrorUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> RestResponseEntityExceptionHandler.java
 * <br><b>Description:</b>
 * Habilita la configuracion para el manejo generico de excepciones
 * de la aplicacion no controladas.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Exception Handler
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler 
	extends ResponseEntityExceptionHandler {
	
	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RestResponseEntityExceptionHandler.class);
	
	/**
	 * Centraliza el manejo de excepciones de la aplicacion no controladas.
	 * Principalmente excepciones de tipo {@link RuntimeException}.
	 * @param ex la excepcion a manejar
	 * @param request es un objeto {@link WebRequest}
	 * @return una instancia de {@link ResponseEntity}
	 */
	@ExceptionHandler(value = { MessagingException.class })
	public ResponseEntity<Object> handleConflict(RuntimeException ex,
			WebRequest request) {
		/* Obtiene error */
		com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(ex);
		LOGGER.warn(error.toString(), ex);
		return handleExceptionInternal(ex, error,
				new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

}
