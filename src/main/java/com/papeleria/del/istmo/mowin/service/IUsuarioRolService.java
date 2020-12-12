package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.dto.RolDTO;
import com.papeleria.del.istmo.mowin.dto.UsuarioDTO;
import com.papeleria.del.istmo.mowin.dto.UsuarioRolDTO;
import com.papeleria.del.istmo.mowin.model.UsuarioRol;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IUsuarioRolService.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 7 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 7 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
public interface IUsuarioRolService {

	/**
	 * obtener lista de usuarios y roles asignados
	 * 
	 * @return lista usuarios roles 
	 * 
	 * @throws ServiceException - en caso de ocurrir un error se lanza un serviceException
	 */
	List<UsuarioRolDTO> getListaUsuarioRol() throws ServiceException;
	
	/**
	 * obtener lista de usuarios y roles asignados
	 * 
	 * @return lista usuarios roles 
	 * 
	 * @throws ServiceException - en caso de ocurrir un error se lanza un serviceException
	 */
	List<UsuarioDTO> getListaUsuarioRolNoAsignados() throws ServiceException;
	
	/**
	 * @param usuarioRol
	 * @return
	 * @throws ServiceException
	 */
	int save(UsuarioRol usuarioRol) throws ServiceException;
	
	/**
	 * @param idUsuario
	 * @param idRol
	 * @return
	 */
	int eliminarUsuarioRol(String idUsuario, int idRol) throws ServiceException;

	/**
	 * @param idUsuario
	 * @return
	 * @throws ServiceException
	 */
	RolDTO getListaUsuarioByIdUser(String idUsuario) throws ServiceException;
}
