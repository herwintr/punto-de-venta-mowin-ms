/**
 * 
 */
package com.papeleria.del.istmo.mowin.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.papeleria.del.istmo.mowin.model.Producto;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 26 oct. 2020
 *
 * Descripcion: Clase IProductoRepository.java creada para 
 * 
 */
public interface IProductoRepository extends CrudRepository<Producto, Integer>{
	
	Page<Producto> findByTipoProductoId(int id, Pageable pageable);
	
	Page<Producto> findAll(Pageable pageable);
	
	Page<Producto> findByTipoProductoIdAndDescripcionLikeIgnoreCase(int id, String descripcion, Pageable pageable);
	
	Page<Producto> findByMarcaIdAndDescripcionLikeIgnoreCase(int id, String descripcion, Pageable pageable);
	
	Page<Producto> findByMarcaIdIn(List<Integer> idsMarca, Pageable pageable);
	
	Page<Producto> findByTipoProductoIdAndMarcaIdInAndDescripcionLikeIgnoreCase(int id, List<Integer> idsMarca, String descripcion, Pageable pageable);
	
	Page<Producto> findByTipoProductoIdAndMarcaIdIn(int id, List<Integer> idsMarca, Pageable pageable);
	
	Page<Producto> findByMarcaIdInAndDescripcionLikeIgnoreCase(List<Integer> idsMarca, String descripcion, Pageable pageable);
	
	Page<Producto> findByTipoProductoIdIn(List<Integer> idsTipo, Pageable pageable);
	
	Page<Producto> findByTipoProductoIdInAndDescripcionLikeIgnoreCase(List<Integer> idsTipo, String descripcion, Pageable pageable);
	
	Page<Producto> findByTipoProductoIdInAndMarcaIdInAndDescripcionLikeIgnoreCase(List<Integer> idsTipo, List<Integer> idsMarca, String descripcion, Pageable pageable);
	
	Page<Producto> findByTipoProductoIdInAndMarcaIdIn(List<Integer> idsTipo, List<Integer> idsMarca, Pageable pageable);
	
	Page<Producto> findByDescripcionLikeIgnoreCase(String descripcion, Pageable pageable);

	List<Producto> findByTipoProductoIdAndDescripcionLikeIgnoreCase(int id, String descripcion);
	
	List<Producto> findByDescripcionLikeIgnoreCase(String descripcion);
	
	
	//@Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1 /*#pageable*/ ORDER BY LASTNAME",
		//   countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
		  // nativeQuery = true)
	//Page<Producto> findByLastname(String lastname, Pageable pageable);*/
	
}