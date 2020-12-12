/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IUsuarioService.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 5 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;

import com.papeleria.del.istmo.mowin.dto.UsuarioDTO;
import com.papeleria.del.istmo.mowin.model.Usuario;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IUsuarioService.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 5 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
public interface IUsuarioService {

	/**
	 * Obtener lista de usuarios almacenados en base de datos
	 * 
	 * @return {@link lista de usuarios}
	 */
	List<UsuarioDTO> findAll() throws ServiceException;
	
	/**
	 * Obtener lista de usuarios almacenados en base de datos
	 * 
	 * @return {@link lista de usuarios}
	 */
	List<UsuarioDTO> findAllLideres() throws ServiceException;
	
	/**
	 * guardado de usuario a base de datos
	 * 
	 * @param usuario - objeto usuario a almacenar a base de datos
	 * @return objeto alamcenado en base 
	 * @throws ServiceException - en caso de ocurrir un error retornar un service exception
	 */
	Usuario save(UsuarioDTO usuario) throws ServiceException;
	
	/**
	 * @param usuario - usuario a actualizar
	 * @return objeto alamcenado en base
	 * @throws ServiceException - en caso de ocurrir un error retornar un service exception
	 */
	Usuario update(Usuario usuario) throws ServiceException;
	
	/**
	 * @param usuario - usuario a actualizar
	 * @return objeto alamcenado en base
	 * @throws ServiceException - en caso de ocurrir un error retornar un service exception
	 */
	int eliminar(String id) throws ServiceException;
	
	
	/**
	 * @param userName
	 * @param passWord
	 * @return
	 */
	UsuarioDTO loginUsuario(String userName, String passWord)throws ServiceException;
	
	/**
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	Usuario obtenerUsuarioById(String id) throws ServiceException;
	
}
