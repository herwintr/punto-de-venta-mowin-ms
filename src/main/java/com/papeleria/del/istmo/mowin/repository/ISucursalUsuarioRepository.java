/**
 * 
 */
package com.papeleria.del.istmo.mowin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.papeleria.del.istmo.mowin.model.SucursalUsuario;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 26 oct. 2020
 *
 * Descripcion: Clase ISucursalUsuarioRepository.java creada para 
 * 
 */
public interface ISucursalUsuarioRepository extends CrudRepository<SucursalUsuario, Integer>{

	@Query("Select dv From SucursalUsuario dv where dv.sucursal.id =:idSucursal order by dv.fechaRegistro desc")
	List<SucursalUsuario> obtenerSucursalUsuarioByIdSucursal(@Param("idSucursal") int idSucursal);

}