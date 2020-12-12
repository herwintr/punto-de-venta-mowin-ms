package com.papeleria.del.istmo.mowin.controller;

import java.util.List;

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

import com.papeleria.del.istmo.mowin.dto.MenusRolesDTO;
import com.papeleria.del.istmo.mowin.service.IMenuService;
import com.papeleria.del.istmo.mowin.util.ErrorUtil;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> RolesMenusController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 23, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 23, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@RestController
@RequestMapping("/roles_menus")
@CrossOrigin(origins = {"*"}, allowCredentials = "false" , allowedHeaders = "*")
public class RolesMenusController {

	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MenuController.class);
	
	@Autowired
	private IMenuService iMenuService;
	
	// Obtener     POSTMAPPING
	@GetMapping
	public ResponseEntity<Object> obtenerMenuRol() {
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.obtenerMenuRol());
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al crear menu rol: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	// Obtener     POSTMAPPING
	@GetMapping("/{idRol}")
	public ResponseEntity<Object> obtenerMenuRol(@PathVariable("idRol") int idRol) {
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.obtenerMenuRol(idRol));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al crear menu rol: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	// Save     POSTMAPPING
	@PostMapping
	public ResponseEntity<Object> guardarMenuRol(@RequestBody List<MenusRolesDTO> menuRoles) {
		ResponseEntity<Object> response = null;
		try {
			this.iMenuService.eliminarMenuRolByIdRol(menuRoles.get(0).getRol().getId());
			response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.crearMenuRol(menuRoles));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al crear menu rol: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	
	// Delete     Deletemapping
	@DeleteMapping("/{idMenu}/{idRol}")
	public ResponseEntity<Object> eliminarMenuRol(@PathVariable("idMenu") int idMenu, @PathVariable("idRol") int idRol) {
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.eliminarMenuRol(idMenu, idRol));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al eliminar menu Rol: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
}
