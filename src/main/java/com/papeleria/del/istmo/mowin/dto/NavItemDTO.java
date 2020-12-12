package com.papeleria.del.istmo.mowin.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> NavItemDTO.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 24, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 24, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@Getter @Setter
public class NavItemDTO {
	
	/**
	 * displayName variable de tipo String 
	 */
	private String displayName;
	
	/**
	 * disabled variable de tipo boolean 
	 */
	private boolean disabled;
	
	/**
	 * iconName variable de tipo String 
	 */
	private String iconName;
	
	/**
	 * route variable de tipo String 
	 */
	private String route;
	
	/**
	 * children variable de tipo List<NavItemDTO> 
	 */
	private List<NavItemDTO> children;
	
}
