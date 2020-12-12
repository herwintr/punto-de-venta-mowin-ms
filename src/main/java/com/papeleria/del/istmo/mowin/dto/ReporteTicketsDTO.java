package com.papeleria.del.istmo.mowin.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> ReporteTicketsDTO.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 26, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 26, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@Getter @Setter
public class ReporteTicketsDTO {

	/**
	 * idEstatus variable de tipo int 
	 */
	private int idEstatus;
	
	/**
	 * cantidad variable de tipo int 
	 */
	private int cantidad;
	
	/**
	 * descAmbiente variable de tipo String 
	 */
	private String descAmbiente;
	
	/**
	 * descEstatus variable de tipo String 
	 */
	private String descEstatus;
	
	/**
	 * totalEstatusAmbiente variable de tipo int 
	 */
	private int totalEstatusAmbiente;
	
}
