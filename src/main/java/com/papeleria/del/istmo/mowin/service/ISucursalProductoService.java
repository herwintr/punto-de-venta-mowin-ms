/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.model.SucursalProducto;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 28 oct. 2020
 *
 * Descripcion: Clase ISucursalProductoService.java creada para 
 * 
 */
public interface ISucursalProductoService {

	List<SucursalProducto> obtenerSucursalProductoByIdSucursal(int idSucursal) throws ServiceException;
	
	SucursalProducto guardar(SucursalProducto sucursalProducto) throws ServiceException;
	
	int eliminarById(int id) throws ServiceException;
	
}
