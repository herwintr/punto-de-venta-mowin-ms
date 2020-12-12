/**
 * 
 */
package com.papeleria.del.istmo.mowin.util;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> ServiceException.java
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
public class ServiceException extends Exception {

	/**
	 * La version de serial.
	 */
	private static final long serialVersionUID = -7143535299705714872L;
	
	/**
	 * Contiene un codigo de error.
	 */
	private final CodigoError codigoError;

	/**
     * Crea una instancia con el mensaje y la causa especificados.
     * @param message el mensaje a establecer
	 * @param cause la causa a establecer
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		this.codigoError = null;
	}

	/**
     * Crea una instancia con la causa especificada.
	 * @param cause la causa a establecer
	 */
	public ServiceException(Throwable cause) {
		super(cause);
		this.codigoError = null;
	}

	/**
     * Crea una instancia con codigo de error, mensaje y causa especificados.
     * @param errorCode es el codigo de error a establecer
     * @param message el mensaje a establecer
	 * @param cause la causa a establecer
	 */
	public ServiceException(CodigoError errorCode, String message,
			Throwable cause) {
		super(message, cause);
		this.codigoError = errorCode;
	}

	/** 
	 * Regresa el valor del atributo codigoError.
	 * @return el atributo codigoError
	 */
	public CodigoError getCodigoError() {
		return codigoError;
	}

}
