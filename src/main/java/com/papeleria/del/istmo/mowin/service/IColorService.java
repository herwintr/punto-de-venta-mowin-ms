/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.model.Color;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 26 oct. 2020
 *
 * Descripcion: Clase IColorService.java creada para 
 * 
 */
public interface IColorService {
	
	/**
	 * Metodo que obtiene la lista de colores
	 * @return retorna la lista de Colores
	 * @throws ServiceException - en caso de ocurrir un error lanzar un serviceException
	 */
	List<Color> obtenerComponentes() throws ServiceException;
	
	/**
	 * @param color
	 * @return
	 * @throws ServiceException - en caso de ocurrir un error lanzar un serviceException
	 */
	Color guardar(Color color) throws ServiceException;
	
	/**
	 * @param id - id a consultar
	 * @return retorna objeto Color
	 * @throws ServiceException - en caso de ocurrir un error lanzar un serviceException
	 */
	Color consultaById(int id) throws ServiceException;
	
	/**
	 * @param id
	 * @return retorna un 1 o 0 en caso el que sea el resultado
	 * @throws ServiceException - en caso de ocurrir un error lanzar un serviceException
	 */
	int eliminarById(int id) throws ServiceException;

}
