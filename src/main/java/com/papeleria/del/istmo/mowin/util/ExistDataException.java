package com.papeleria.del.istmo.mowin.util;

/**
 * Excepcion para cuando la se quiera ingresar un objeto qur ya existe.
 */
public class ExistDataException extends RuntimeException {

	/**
	 * Uid generado.
	 */
	private static final long serialVersionUID = 2727426563501622131L;

	/**
	 * Constructor por default.
	 */
	public ExistDataException() {
		super();
	}

	/**
	 * constructor que recibe el mensaje de error.
	 * 
	 * @param message de error.
	 */
	public ExistDataException(String message) {
		super(message);
	}

	/**
	 * Constructor que recibe throwable
	 * 
	 * @param cause de error.
	 */
	public ExistDataException(Throwable cause) {
		super(cause);
	}

}
