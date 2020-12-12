/**
 * 
 */
package com.papeleria.del.istmo.mowin.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 29 nov. 2020
 *
 * Descripcion: Clase TipoProductoGroup.java creada para 
 * 
 */
@Getter
@Setter
public class TipoProductoGroup implements Serializable{

	/**
	 * Variable serialVersionUID de tipo  long
	 */
	private static final long serialVersionUID = 9073870801448332503L;

	/**
	 * Variable id de tipo  int
	 */
	private int id;
	
	/**
	 * Variable tipoProducto de tipo  String
	 */
	private String tipoProducto;
	
	/**
	 * Variable cantidad de tipo  int
	 */
	private int cantidad;

	public TipoProductoGroup(int id, String tipoProducto, int cantidad) {
		super();
		this.id = id;
		this.tipoProducto = tipoProducto;
		this.cantidad = cantidad;
	}
	
	
}
