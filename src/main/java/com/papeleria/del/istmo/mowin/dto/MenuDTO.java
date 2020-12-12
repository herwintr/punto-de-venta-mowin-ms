/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MenuDTO.java
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
package com.papeleria.del.istmo.mowin.dto;

import java.util.List;

import javax.validation.constraints.Null;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MenuDTO.java
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
@Getter @Setter
public class MenuDTO {
	
	/**
	 * id variable de tipo int 
	 */
	private int id;
	
	/**
	 * nombre variable de tipo String 
	 */
	private String nombre;
	
	/**
	 * icono variable de tipo String 
	 */
	private String icono;
	
	/**
	 * url variable de tipo String 
	 */
	private String url;
	
	/**
	 * menuPadre variable de tipo int 
	 */
	private MenuDTO padre;
	
	/**
	 * menusHijos variable de tipo List<MenuDTO> 
	 */
	@Null
	private List<MenuDTO> menusHijos;

}
