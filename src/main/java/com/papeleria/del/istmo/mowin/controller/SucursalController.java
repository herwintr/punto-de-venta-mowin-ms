/**
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

import com.papeleria.del.istmo.mowin.model.Sucursal;
import com.papeleria.del.istmo.mowin.service.ISucursalService;
import com.papeleria.del.istmo.mowin.util.ErrorUtil;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 28 oct. 2020
 *
 * Descripcion: Clase SucursalController.java creada para 
 * 
 */
@RestController
@RequestMapping("/sucursales")
@CrossOrigin(origins = {"*"}, allowCredentials = "false" , allowedHeaders = "*")
public class SucursalController {
	/**
	 * La instancia para logging.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SucursalController.class);

	/**
	 * Variable iSucursalService de tipo  ISucursalService
	 */
	@Autowired
	private ISucursalService iSucursalService;
	
	/**
	 * Obtener lista de sucursals disponible
	 * @return lista de sucursals 
	 */
	@GetMapping
	public ResponseEntity<Object> listarSucursas(){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iSucursalService.obtenerSucursal());
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al consultar sucursal : {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
			
		}
		return response;
	}
	
	@PostMapping
	public ResponseEntity<Object> guardarSucursa(@RequestBody Sucursal sucursal){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iSucursalService.guardar(sucursal));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al crear sucursal: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> guardarSucursa(@PathVariable("id") int id, @RequestBody Sucursal sucursal){
		ResponseEntity<Object> response = null;
		try {
			Sucursal sucBase = this.iSucursalService.consultaById(id);
			sucBase.setCveSucursal(sucursal.getCveSucursal());
			sucBase.setDireccion(sucursal.getDireccion());
			sucBase.setNombre(sucursal.getNombre());
			sucBase.setRfc(sucursal.getRfc());
			sucBase.setTelefono(sucursal.getTelefono());
			response = ResponseEntity.status(HttpStatus.OK).body(this.iSucursalService.guardar(sucBase));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al crear sucursal: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> guardarSucursa(@PathVariable("id") int id){
		ResponseEntity<Object> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(this.iSucursalService.eliminarById(id));
		}catch(ServiceException | RuntimeException e) {
			/* Solo se informa. */
			LOGGER.warn("Error al crear sucursal: {}", e);
			com.papeleria.del.istmo.mowin.util.Error error = ErrorUtil.obtenerUsando(e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
		return response;
	}
}
