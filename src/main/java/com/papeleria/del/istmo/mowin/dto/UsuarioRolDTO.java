/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioRol.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 6 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioRol.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 6 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@Getter @Setter
public class UsuarioRolDTO implements Serializable{

	/**
	 * serialVersionUID variable de tipo long 
	 */
	private static final long serialVersionUID = -8022872425461421612L;

	/**
	 * usuario variable de tipo Usuario 
	 */
	private UsuarioDTO usuario;
	
	/**
	 * rol variable de tipo Rol 
	 */
	private RolDTO rol;

}