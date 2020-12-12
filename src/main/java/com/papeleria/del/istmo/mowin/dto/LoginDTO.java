/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> LoginDTO.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 14, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 14, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> LoginDTO.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 14, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 14, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@Getter @Setter
public class LoginDTO implements Serializable{

	/**
	 * serialVersionUID variable de tipo long 
	 */
	private static final long serialVersionUID = 3158749510137802826L;
	
	/**
	 * userName variable de tipo String 
	 */
	@NotNull(message = "{message.validate.null}")
	@NotBlank(message = "{message.validate.blank}")
	private String userName;
	
	/**
	 * passWord variable de tipo String 
	 */
	@NotNull(message = "{message.validate.null}")
	@NotBlank(message = "{message.validate.blank}")
	private String passWord;

}
