/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioRolController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 7 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 7 feb. 2020 Herwin: Creacion de la clase
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleria.del.istmo.mowin.model.UsuarioRol;
import com.papeleria.del.istmo.mowin.service.IUsuarioRolService;
import com.papeleria.del.istmo.mowin.util.ErrorUtil;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioRolController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 7 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 7 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@RestController
@RequestMapping("/usuarios_roles")
@CrossOrigin(origins = {"*"}, allowCredentials = "false" , allowedHeaders = "*")
public class UsuarioRolController {

	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UsuarioRolController.class);

	/**
	 * iUsuarioRolService variable de tipo IUsuarioRolService 
	 */
	@Autowired
	private IUsuarioRolService iUsuarioRolService;
	
	/**
	 * obtener la lista de usuarios Roles
	 * 
	 * @return lista de roles y usuarios
	 */
	@GetMapping
	public ResponseEntity<Object> getUsuarioRoles(){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioRolService.getListaUsuarioRol());
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Usuario no encontrado {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;	
	}
	
	@PostMapping
	public ResponseEntity<Object> guardarUsuarioRol(@RequestBody UsuarioRol usuarioRol){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioRolService.save(usuarioRol));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Usuario no encontrado {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;	
	}

	
	/**
	 * obtener la lista de usuarios Roles
	 * 
	 * @return lista de roles y usuarios
	 */
	@GetMapping("/no_asignados")
	public ResponseEntity<Object> getUsuarioRolesNoAsignados(){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioRolService.getListaUsuarioRolNoAsignados());
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Usuario no encontrado {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;	
	}
	
	
	@DeleteMapping("/{idUsuario}/{idRol}")
	public ResponseEntity<Object> guardarUsuarioRol(@PathVariable("idUsuario") String idUsuario, @PathVariable("idRol") int idRol){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioRolService.eliminarUsuarioRol(idUsuario, idRol));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Usuario no encontrado {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;	
	}
}