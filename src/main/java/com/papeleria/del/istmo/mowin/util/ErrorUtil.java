/**
 * 
 */
package com.papeleria.del.istmo.mowin.util;


import com.papeleria.del.istmo.mowin.util.Error.ErrorMessage;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-notificacion-service
 * <br><b>Class:</b> ErrorUtil.java
 * <br><b>Description:</b>
 * Clase util para crear instancias de errores.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 6 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Util
 * 
 */
public final class ErrorUtil {
	
	/**
	 * Constructor privado.
	 */
	private ErrorUtil() {
		super();
	}
	
	/**
	 * Obtiene un objeto {@link Error} con la informacion proporcionada.
	 * @return la instancia de error generada
	 * @param objeto - parametro para el objeto
	 */
	public static Error obtenerUsando(Object objeto) {
		Error error = null;
		if(objeto instanceof ServiceException) {
			error = obtenerUsando((ServiceException) objeto);
		}else if(objeto instanceof RuntimeException ){
			error = obtenerUsando((RuntimeException) objeto);
		}
		return error;
	}
	
	/**
	 * Obtiene un objeto {@link Error} con la informacion proporcionada.
	 * @param e referencia a una excepcion de servicio
	 * @return la instancia de error generada
	 */
	public static Error obtenerUsando(ServiceException e) {
		return setError(e.getCodigoError(), CodigoError.NO_ESPECIFICADO.valor(), CodigoError.NO_ESPECIFICADO.razon(), 
				CodigoError.NO_ESPECIFICADO.nivel().valor(), e);
	}
	
	/**
	 * Obtiene un objeto {@link Error} con la informacion proporcionada.
	 * @param e referencia a una excepcion runtime
	 * @return la instancia de error generada
	 */
	public static Error obtenerUsando(RuntimeException e) {
		Error error = new Error();
		ErrorMessage errorMessage = new ErrorMessage();
		
		/* Codigo de error. */
		errorMessage.setCode(CodigoError.REPOSITORY_POSGRES.valor());
		errorMessage.setMessage(CodigoError.REPOSITORY_POSGRES.razon());
		errorMessage.setLevel(CodigoError.REPOSITORY_POSGRES.nivel().valor());
		
		/* Excepcion. */
		errorMessage.setDescription(e.getMessage());
		if (e.getCause() != null) {
			errorMessage.setMoreInfo(e.getCause().getMessage());
		}
		
		/* Agrega */
		error.addError(errorMessage);
		return error;
	}
	
	/**
	 * Obtiene un objeto {@link Error} con la informacion proporcionada.
	 * @param e referencia a una excepcion de servicio
	 * @return la instancia de error generada
	 */
	public static Error obtenerUsando(DataAccessException e) {
		return setError(e.getCodigoError(), CodigoError.NO_ESPECIFICADO.valor(), CodigoError.NO_ESPECIFICADO.razon(), 
				CodigoError.NO_ESPECIFICADO.nivel().valor(), e);
	}
	
	/**
	 * Metodo para inicializar el objeto con el error
	 * @param codigoError objeto con detalle de lo ocurrido
	 * @param codigo codigo de error de lo ocurrido
	 * @param message mensaje de descripcion del error
	 * @param nivel nivel del error que ocurrio
	 * @param e excepcion ocurrida en el error
	 * @return Objeto Error con detalle de lo ocurrido
	 */
	private static Error setError(CodigoError codigoError, String codigo, String message, 
			String nivel, Exception e) {
		Error error = new Error();
		ErrorMessage errorMessage = new ErrorMessage();		
		/* Codigo de error. */
		if (codigoError != null) {
			errorMessage.setCode(codigoError.valor());
			errorMessage.setMessage(codigoError.razon());
			errorMessage.setLevel(codigoError.nivel().valor());
		} else {
			errorMessage.setCode(codigo);
			errorMessage.setMessage(message);
			errorMessage.setLevel(nivel);
		}	
		/* Excepcion. */
		errorMessage.setDescription(e.getMessage());
		if (e.getCause() != null) {
			errorMessage.setMoreInfo(e.getCause().getMessage());
		}		
		/* Agrega */
		error.addError(errorMessage);
		return error;
	}
	
}
