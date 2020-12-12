/**
 * 
 */
package com.papeleria.del.istmo.mowin.util;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> StringUtil.java
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
public final class StringUtil {
	
	/**
	 * Constructor privado.
	 */
	private StringUtil() {
		super();
	}
	
	/**
	 * Concatena los objetos dados en una representacion de <code>String</code>.
	 * @param objs los objetos a concatenar
	 * @return el <code>String</code> generado
	 */
	public static String concat(Object ... objs) {
		if (objs == null) {
			return "null";
		}
		StringBuilder sBuilder = new StringBuilder();
		for (Object obj : objs) {
			sBuilder.append(obj);
		}
		return sBuilder.toString();
	}
	
	/**
	 * Metodo para parsear un valor numerico de cadena a entero.
	 * @param cadena valor a parsear
	 * @return valor de tipo numero
	 */
	public static int parseStringToInt(String cadena) {
		int numero = 0;
		try {
			numero = Integer.parseInt(cadena);
		} catch (NumberFormatException nfe){
			numero = -1;
		}
		return numero;
	}
	
}
