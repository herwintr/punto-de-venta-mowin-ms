/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.model.SucursalUsuario;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 28 oct. 2020
 *
 * Descripcion: Clase ISucursalUsuarioService.java creada para 
 * 
 */
public interface ISucursalUsuarioService {

	List<SucursalUsuario> obtenerSucursalUsuarioByIdSucursal(int idSucursal) throws ServiceException;
	
	SucursalUsuario guardar(SucursalUsuario sucursalUsuario) throws ServiceException;
	
	int eliminarById(int id) throws ServiceException;
	
}
