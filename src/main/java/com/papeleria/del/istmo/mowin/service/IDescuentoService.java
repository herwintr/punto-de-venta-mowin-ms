/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.model.Descuento;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 26 oct. 2020
 *
 * Descripcion: Clase IDescuentoService.java creada para 
 * 
 */
public interface IDescuentoService {

	/**
	 * Metodo que realiza consulta general de la tabla Descuento
	 * @return retorna lista de descuentos
	 * @throws ServiceException en caso de ocurrir un error lanzar un {@link ServiceException}
	 */
	List<Descuento> obtenerComponentes() throws ServiceException;
	
	/**
	 * Guardar objeto en la base de datos.
	 * @param descuentos - objeto descuento a almacenar en la base de datos
	 * @return retorna objeto Descuento de la base de datos
	 * @throws ServiceException en caso de ocurrir un error lanzar un {@link ServiceException}
	 */
	Descuento guardar(Descuento descuentos) throws ServiceException;
	
	/**
	 * @param id - parametro id para consultar en la base 
	 * @return retorna objeto de la base de datos
	 * @throws ServiceException en caso de ocurrir un error lanzar un {@link ServiceException}
	 */
	Descuento consultaById(int id) throws ServiceException;
	
	/**
	 * @param id - parametro id para eliminar en la base 
	 * @return retorna un 1 en caso exitos y 0 en caso contrario
	 * @throws ServiceException en caso de ocurrir un error lanzar un {@link ServiceException}
	 */
	int eliminarById(int id) throws ServiceException;
	
}
