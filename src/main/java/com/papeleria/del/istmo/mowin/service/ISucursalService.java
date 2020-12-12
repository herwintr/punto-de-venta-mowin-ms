/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.model.Sucursal;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 28 oct. 2020
 *
 * Descripcion: Clase ISucursalService.java creada para 
 * 
 */
public interface ISucursalService {

	List<Sucursal> obtenerSucursal() throws ServiceException;
	
	Sucursal guardar(Sucursal sucursal) throws ServiceException;
	
	Sucursal consultaById(int id) throws ServiceException;
	
	int eliminarById(int id) throws ServiceException;
	
}
