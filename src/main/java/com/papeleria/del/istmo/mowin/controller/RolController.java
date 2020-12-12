/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> RolController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 9 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 9 feb. 2020 Herwin: Creacion de la clase
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleria.del.istmo.mowin.model.Rol;
import com.papeleria.del.istmo.mowin.service.IRolService;
import com.papeleria.del.istmo.mowin.util.ErrorUtil;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> RolController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 9 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 9 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = {"*"}, allowCredentials = "false" , allowedHeaders = "*")
public class RolController {
	
	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RolController.class);

	// consulta es GET
	@Autowired
	private IRolService iRolService;
	
	@GetMapping
	public ResponseEntity<Object> getRol() {
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iRolService.leerRol());
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al consultar roles: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	// Save     POSTMAPPING
	@PostMapping
	public ResponseEntity<Object> guardarRol(@RequestBody Rol rol) {
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iRolService.crearRol(rol));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al crear rol: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	// eliminacion DELETEMAPPING
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarRol(@PathVariable("id") int id) {
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iRolService.eliminarRol(id));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al eliminar rol: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}

	// Update PUTMAPPIN
	@PutMapping("/{id}")
	public ResponseEntity<Object> eliminarRol(@RequestBody Rol rolParametro, @PathVariable("id") int id) {
		ResponseEntity<Object> response = null;
		try {
			Rol rolBaseDatos = this.iRolService.consultaRol(id);
			rolBaseDatos.setDescripcion(rolParametro.getDescripcion());
			response = ResponseEntity.status(HttpStatus.OK).body(this.iRolService.actualizarRol(rolBaseDatos));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al eliminar rol: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	// Update PUTMAPPIN
	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerRolById( @PathVariable("id") int id) {
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iRolService.consultaRol(id));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al eliminar rol: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
}
