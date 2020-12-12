/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> Estatus.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 12, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 12, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.util;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> Estatus.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 12, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 12, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
public enum Estatus {
	
	FN("FN", "Finalizado"),
	C("C",""),
	;
	
	String clave;
	
	String descripcion;
	
	/**
	 * @param clave
	 * @param descripcion
	 */
	Estatus(String clave,String descripcion){
		this.clave = clave;
		this.descripcion = descripcion;
	}

	/**
	 * Gets the operator related to description.
	 *
	 * @param clave tipo de operacion a realizar
	 * @return {@link Estatus} Type of operator.
	 * @throws ServiceException en caso de ocurrir algo inesperado lanzar un
	 * serviceException
	 */
	public static Estatus fromLetter(String clave) throws ServiceException {
		for (Estatus operator : Estatus.values()) {
			if (operator.clave.equalsIgnoreCase(clave)) {
				return operator;
			}
		}
		throw new ServiceException("(" + clave + ")", new Throwable("Error"));
	}
}
