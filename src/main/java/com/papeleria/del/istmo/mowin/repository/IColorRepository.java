/**
 * 
 */
package com.papeleria.del.istmo.mowin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.papeleria.del.istmo.mowin.model.Color;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 26 oct. 2020
 *
 * Descripcion: Clase IColorRepository.java creada para 
 * 
 */
public interface IColorRepository extends CrudRepository<Color, Integer>{
	
	@Query("FROM Color order by descripcion asc")
	List<Color> findAllOrderByDescripcion();
}