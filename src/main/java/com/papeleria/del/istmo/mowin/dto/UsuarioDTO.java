/**
 * 
 */
package com.papeleria.del.istmo.mowin.dto;

import java.io.Serializable;
import java.util.List;

import com.papeleria.del.istmo.mowin.model.Descuento;

import lombok.Getter;
import lombok.Setter;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 18 oct. 2020
 *
 * Descripcion: Clase ClienteDto.java creada para 
 * 
 */
@Getter @Setter
public class UsuarioDTO implements Serializable{

	/**
	 * Variable serialVersionUID de tipo  long
	 */
	private static final long serialVersionUID = -6850202257282990953L;

	/**
	 * Variable id de tipo  int
	 */
	private String id;
	
	/**
	 * Variable nombre de tipo  String
	 */
	private String nombre;
	
	/**
	 * Variable apellidos de tipo  String
	 */
	private String apellidos;
	
	/**
	 * Variable fb de tipo  String
	 */
	private String fb;
	
	/**
	 * Variable tw de tipo  String
	 */
	private String tw;
	
	/**
	 * Variable tel de tipo  String
	 */
	private String tel;
	
	/**
	 * Variable correo de tipo  String
	 */
	private String correo;
	
	/**
	 * Variable direccion de tipo  String
	 */
	private String direccion;
	
	/**
	 * Variable rfc de tipo  String
	 */
	private String rfc;
	
	/**
	 * Variable fechaCreacion de tipo  String
	 */
	private String fechaCreacion;
	
	/**
	 * Variable usuario de tipo  String
	 */
	private String usuario;
	
	/**
	 * Variable password de tipo  String
	 */
	private String password;

	/**
	 * Variable descuento de tipo  DescuentoDto
	 */
	private Descuento descuento;
	
	/**
	 * idLider variable de tipo int 
	 */
	private UsuarioDTO jefe;
	
	/**
	 * liderProyecto variable de tipo boolean 
	 */
	private boolean encargado;
	
	/**
	 * subordinados variable de tipo List<Usuario> 
	 */
	private List<UsuarioDTO> subordinados;	
	
	/**
	 * Variable rol de tipo  RolDto
	 */
	private RolDTO rol;
	
	/**
	 * Variable status de tipo  int
	 */
	private int status;
	
}
