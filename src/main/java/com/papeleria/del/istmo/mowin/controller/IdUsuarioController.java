/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IdUsuarioController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 21, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 21, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleria.del.istmo.mowin.dto.ClaveDTO;
import com.papeleria.del.istmo.mowin.dto.UsuarioDTO;
import com.papeleria.del.istmo.mowin.service.IUsuarioService;
import com.papeleria.del.istmo.mowin.util.ErrorUtil;
import com.papeleria.del.istmo.mowin.util.ServiceException;
import com.papeleria.del.istmo.mowin.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IdUsuarioController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 21, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 21, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@RestController
@RequestMapping("/claves")
@CrossOrigin(origins = {"*"}, allowCredentials = "false" , allowedHeaders = "*")
public class IdUsuarioController {

	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(IdUsuarioController.class);
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	private String idUSuario = "USR_0";
	
	@GetMapping
	private ResponseEntity<Object> obtenerIdUSuario(){
		ResponseEntity<Object> response = null;
		try {
			List<UsuarioDTO> listaUsuarios = this.iUsuarioService.findAll();
			ClaveDTO clave = new ClaveDTO();
			String concat = StringUtil.concat(this.idUSuario, (listaUsuarios.size() + 1));
			clave.setIdGenerado(concat);
			response = ResponseEntity.status(HttpStatus.OK).body(clave);
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn(StringUtil.concat("Error al obtener idUSuario"), e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
}
