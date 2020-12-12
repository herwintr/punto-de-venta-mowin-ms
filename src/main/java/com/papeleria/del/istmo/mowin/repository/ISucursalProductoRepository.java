/**
 * 
 */
package com.papeleria.del.istmo.mowin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.papeleria.del.istmo.mowin.model.SucursalProducto;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 26 oct. 2020
 *
 * Descripcion: Clase ISucursalProductoRepository.java creada para 
 * 
 */
public interface ISucursalProductoRepository extends CrudRepository<SucursalProducto, Integer>{

	@Query("Select dv From SucursalProducto dv where dv.sucursal.id =:idSucursal order by dv.fechaRegistro desc")
	List<SucursalProducto> obtenerSucursalProductoByIdSucursal(@Param("idSucursal") int idSucursal);

}