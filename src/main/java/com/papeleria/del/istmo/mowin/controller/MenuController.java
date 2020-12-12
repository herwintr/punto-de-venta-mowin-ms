/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MenuController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 19, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 19, 2020 Herwin: Creacion de la clase
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

import com.papeleria.del.istmo.mowin.model.Menu;
import com.papeleria.del.istmo.mowin.service.IMenuService;
import com.papeleria.del.istmo.mowin.util.ErrorUtil;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MenuController.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 19, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 19, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = {"*"}, allowCredentials = "false" , allowedHeaders = "*")
public class MenuController {
	
	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MenuController.class);
	
	@Autowired
	private IMenuService iMenuService;
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Object> obtenerMenuByCorreo(@PathVariable("idUsuario") String idUsuario){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.obtenerMenuByUsuario(idUsuario));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al leer el menu del usuario : {}: {}",idUsuario, e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	@GetMapping
	public ResponseEntity<Object> obtenerMenus(){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.obtenerMenu());
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al leer el menus}: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	@GetMapping("/padres/{idMenu}")
	public ResponseEntity<Object> obtenerMenusPadres(@PathVariable("idMenu") int idMenu){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.obtenerMenuPadres(idMenu));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al leer el menus}: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	// Save     POSTMAPPING
	@PostMapping
	public ResponseEntity<Object> guardar(@RequestBody Menu menu) {
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.guardar(menu));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al crear menu: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	// eliminacion DELETEMAPPING
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
			ResponseEntity<Object> response = null;
			try {
				response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.eliminarById(id));
			}catch(ServiceException | RuntimeException e) {
				/* Solo se informa. */
				LOGGER.warn("Error al eliminar menu: {}", e);
				com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
			}
			return response;
		}

		// Update PUTMAPPIN
		@PutMapping("/{id}")
		public ResponseEntity<Object> eliminar(@RequestBody Menu parametro, @PathVariable("id") int id) {
			ResponseEntity<Object> response = null;
			try {
				Menu menudBaseDatos = this.iMenuService.consultaById(id);
				menudBaseDatos.setIcono(parametro.getIcono());
				menudBaseDatos.setNombre(parametro.getNombre());
				menudBaseDatos.setUrl(parametro.getUrl());
				menudBaseDatos.setPadre(null);
				if(parametro.getPadre()!=null) {
					menudBaseDatos.setPadre(parametro.getPadre());
				}
				response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.guardar(menudBaseDatos));
			}catch(ServiceException | RuntimeException e) {
				/* Solo se informa. */
				LOGGER.warn("Error al eliminar menu: {}", e);
				com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
			}
			return response;
		}
		
		// eliminacion DELETEMAPPING
		@GetMapping("/consulta/{id}")
		public ResponseEntity<Object> obtenerEstatusById(@PathVariable("id") int id) {
			ResponseEntity<Object> response = null;
			try {
				response = ResponseEntity.status(HttpStatus.OK).body(this.iMenuService.consultaById(id));
			}catch(ServiceException | RuntimeException e) {
				/* Solo se informa. */
				LOGGER.warn("Error al eliminar menu: {}", e);
				com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
			}
			return response;
		}
		
}
