/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IRolService.java
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
package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.model.Rol;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IRolService.java
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
public interface IRolService {

	//C
	Rol crearRol(Rol rol) throws ServiceException;

	//R
	List<Rol> leerRol() throws ServiceException;
	
	//U
	Rol actualizarRol(Rol rol) throws ServiceException;
	
	//D
	int eliminarRol(int idRol) throws ServiceException;
	
	//C
	Rol consultaRol(int id) throws ServiceException;

}
