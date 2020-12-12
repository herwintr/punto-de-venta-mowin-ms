/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IMenuService.java
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
package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.dto.MenuDTO;
import com.papeleria.del.istmo.mowin.dto.MenusRolesDTO;
import com.papeleria.del.istmo.mowin.dto.NavItemDTO;
import com.papeleria.del.istmo.mowin.model.Menu;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IMenuService.java
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
public interface IMenuService {

	List<MenuDTO> obtenerMenuByCorreo(String correo) throws ServiceException;
	
	List<NavItemDTO> obtenerMenuByUsuario(String usuario) throws ServiceException;
	
	List<MenuDTO> obtenerMenu() throws ServiceException;

	List<MenuDTO> obtenerMenuPadres(int idMenu) throws ServiceException;

	List<MenusRolesDTO> obtenerMenuRol() throws ServiceException;
	
	List<MenusRolesDTO> obtenerMenuRol(int idRol) throws ServiceException;
	
	MenuDTO guardar(Menu menu) throws ServiceException;
	
	Menu consultaById(int id) throws ServiceException;
	
	int eliminarById(int id) throws ServiceException;
	
	int crearMenuRol(List<MenusRolesDTO> listaMenuRoles) throws ServiceException ;
	
	int eliminarMenuRol(int idMenu, int idRol) throws ServiceException ;
	
	int eliminarMenuRolByIdRol(int idRol) throws ServiceException;
}
