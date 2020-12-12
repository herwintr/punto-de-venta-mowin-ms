/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> LoguinController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 13, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 13, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleria.del.istmo.mowin.dto.LoginDTO;
import com.papeleria.del.istmo.mowin.service.IUsuarioService;
import com.papeleria.del.istmo.mowin.util.ErrorUtil;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> LoguinController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 13, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 13, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"*"}, allowCredentials = "false" , allowedHeaders = "*")
public class LoginController {

	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginController.class);
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@PostMapping
	public ResponseEntity<Object> obtenerSession(@RequestBody LoginDTO login){

		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.loginUsuario(login.getUserName(), login.getPassWord()));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al consultar prioridad : {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	
	}
}
