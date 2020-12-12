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

import com.papeleria.del.istmo.mowin.dto.UsuarioDTO;
import com.papeleria.del.istmo.mowin.model.Usuario;
import com.papeleria.del.istmo.mowin.service.IUsuarioService;
import com.papeleria.del.istmo.mowin.util.ErrorUtil;
import com.papeleria.del.istmo.mowin.util.ServiceException;
import com.papeleria.del.istmo.mowin.util.StringUtil;


/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 5 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin(origins = {"*"}, allowCredentials = "false" , allowedHeaders = "*")
public class UsuarioController {
	
	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UsuarioController.class);
	
	/**
	 * iUsuarioService variable de tipo IUsuarioService 
	 */
	@Autowired
	private IUsuarioService iUsuarioService;
	
	/**
	 * servicio para guardar usuarios
	 * 
	 * @param usuario - objeto usuario para almacenar
	 * @return el usuario almacenado
	 */
	@PostMapping
	public ResponseEntity<Object> postUsuario(@RequestBody UsuarioDTO usuario){
		ResponseEntity<Object> response = null;
		try {
			usuario.setStatus(1);
			
			response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.save(usuario));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn(StringUtil.concat(
					"Usuario no se pudo guardar en base: ", 
					usuario), e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	/**
	 * servicio para obtener la lista de usuarios
	 * @return lista de usuarios almacenado en base
	 */
	@GetMapping
	public ResponseEntity<Object> getUsuarios(){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.findAll());
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Usuario no se pudo consultar en base: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	/**
	 * servicio para obtener la lista de usuarios
	 * @return lista de usuarios almacenado en base
	 */
	@GetMapping("/lideres")
	public ResponseEntity<Object> getUsuariosLideres(){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.findAllLideres());
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Usuario no se pudo guardar en base: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	// eliminacion DELETEMAPPING
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminarusuario(@PathVariable("id") String id) {
			ResponseEntity<Object> response = null;
			try {
				Usuario userSave = this.iUsuarioService.obtenerUsuarioById(id);
				userSave.setStatus(0);
				response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.update(userSave));
			}catch(ServiceException | RuntimeException e) {
				/* Solo se informa. */
				LOGGER.warn("Error al eliminar usuario: {}", e);
				com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
			}
			return response;
		}

		// Update PUTMAPPIN
		@PutMapping("/{id}")
		public ResponseEntity<Object> eliminarusuario(@RequestBody UsuarioDTO userParametro, @PathVariable("id") String id) {
			ResponseEntity<Object> response = null;
			try {
				userParametro.setStatus(0);
				response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.save(userParametro));
			}catch(ServiceException | RuntimeException e) {
				/* Solo se informa. */
				LOGGER.warn("Error al eliminar usuario: {}", e);
				com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
			}
			return response;
		}
		
		// Update PUTMAPPIN
		@PutMapping("/update/{id}")
		public ResponseEntity<Object> updateusuario(@RequestBody UsuarioDTO userParametro, @PathVariable("id") String id) {
			ResponseEntity<Object> response = null;
			try {
				response = ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.save(userParametro));
			}catch(ServiceException | RuntimeException e) {
				/* Solo se informa. */
				LOGGER.warn("Error al eliminar usuario: {}", e);
				com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
			}
			return response;
		}
		
		

}