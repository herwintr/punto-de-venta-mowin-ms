/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> ProyectoDTO.java
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
 */
package com.papeleria.del.istmo.mowin.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Null;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> ProyectoDTO.java
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
@Getter @Setter	
public class ProyectoDTO implements Serializable{

	/**
	 * serialVersionUID variable de tipo long 
	 */
	private static final long serialVersionUID = 9067944426692513277L;

	/**
	 * id variable de tipo int 
	 */
	private int id;
	
	/**
	 * claveProyecto variable de tipo String 
	 */
	private String claveProyecto;
	
	/**
	 * nombreProyecto variable de tipo String 
	 */
	private String nombreProyecto;
	
	/**
	 * descripcion variable de tipo String 
	 */
	private String descripcion;
	
	/**
	 * fechaCreacion variable de tipo LocalDateTime 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaCreacion;
	
	/**
	 * usuarioPropietario variable de tipo UsuarioDTO 
	 */
	@Null
	private UsuarioDTO usuarioPropietario;
	
	/**
	 * estatus variable de tipo boolean 
	 */
	private boolean estatus;
}
