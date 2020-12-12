/**
 * 
 */
package com.papeleria.del.istmo.mowin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.papeleria.del.istmo.mowin.model.Marca;

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
public interface IMarcaRepository extends CrudRepository<Marca, Integer>{
	
	@Query("FROM Marca order by descripcion asc")
	List<Marca> findAllOrderByDescripcion();
		
	@Query(value ="   SELECT m.id, m.descripcion, count(m.id) " + 
				"  		FROM PAP_MON_WIN_CAT_PROD p " + 
				" INNER JOIN PAP_MON_WIN_CAT_TIPO_PROD tp " + 
				"         ON p.tipo_producto = tp.id " + 
				" INNER JOIN PAP_MON_WIN_CAT_MARCA m " + 
				"         ON p.marca = m.id " + 
				"      WHERE p.status = 1 " + 
				"        AND tp.status = 1" + 
				"        AND tp.id = :idTipoProd" + 
				"        AND lower(p.descripcion) like lower(:desc)" + 
				"   GROUP BY m.id;", nativeQuery = true)
	List<Object[]> listarTipoProductoAgrupadoIdTipoDesc(@Param("idTipoProd") int idTipoProd, @Param("desc") String desc);
	
		
	@Query(value ="   SELECT m.id, m.descripcion, count(m.id) " + 
				"  		FROM PAP_MON_WIN_CAT_PROD p " + 
				" INNER JOIN PAP_MON_WIN_CAT_TIPO_PROD tp " + 
				"         ON p.tipo_producto = tp.id " + 
				" INNER JOIN PAP_MON_WIN_CAT_MARCA m " + 
				"         ON p.marca = m.id " + 
				"      WHERE p.status = 1 " + 
				"        AND tp.status = 1" + 
				"        AND tp.id in :idTipoProds" + 
				"        AND lower(p.descripcion) like lower(:desc)" + 
				"   GROUP BY m.id;", nativeQuery = true)
	List<Object[]> listarTipoProductoAgrupadoIdTipoDesc(@Param("idTipoProds") List<Integer> idTipoProd, @Param("desc") String desc);
	
	@Query(value ="   SELECT m.id, m.descripcion, count(m.id) " + 
				"  		FROM PAP_MON_WIN_CAT_PROD p " + 
				" INNER JOIN PAP_MON_WIN_CAT_TIPO_PROD tp " + 
				"         ON p.tipo_producto = tp.id " + 
				" INNER JOIN PAP_MON_WIN_CAT_MARCA m " + 
				"         ON p.marca = m.id " + 
				"      WHERE p.status = 1 " + 
				"        AND tp.status = 1" + 
				"        AND tp.id = :idTipoProd" + 
				"   GROUP BY m.id;", nativeQuery = true)
	List<Object[]> listarTipoProductoAgrupadoIdTipoProd(@Param("idTipoProd") int idTipoProd);
	
	
	
	@Query(value ="   SELECT m.id, m.descripcion, count(m.id) " + 
				"  		FROM PAP_MON_WIN_CAT_PROD p " + 
				" INNER JOIN PAP_MON_WIN_CAT_TIPO_PROD tp " + 
				"         ON p.tipo_producto = tp.id " + 
				" INNER JOIN PAP_MON_WIN_CAT_MARCA m " + 
				"         ON p.marca = m.id " + 
				"      WHERE p.status = 1 " + 
				"        AND tp.status = 1" + 
				"        AND tp.id in :idTipoProds" + 
				"   GROUP BY m.id;", nativeQuery = true)
	List<Object[]> listarTipoProductoAgrupadoIdTipoProd(@Param("idTipoProds") List<Integer> idTipoProd);
	
	@Query(value ="   SELECT m.id, m.descripcion, count(m.id) " + 
			"  		FROM PAP_MON_WIN_CAT_PROD p " + 
			" INNER JOIN PAP_MON_WIN_CAT_TIPO_PROD tp " + 
			"         ON p.tipo_producto = tp.id " + 
			" INNER JOIN PAP_MON_WIN_CAT_MARCA m " + 
			"         ON p.marca = m.id " + 
			"      WHERE p.status = 1 " + 
			"        AND tp.status = 1" + 
			"        AND lower(p.descripcion) like lower(:desc)" + 
			"   GROUP BY m.id;", nativeQuery = true)
	List<Object[]> listarTipoProductoAgrupadoDesc(@Param("desc") String desc);
	
	@Query(value ="   SELECT m.id, m.descripcion, count(m.id) " + 
			"  		FROM PAP_MON_WIN_CAT_PROD p " + 
			" INNER JOIN PAP_MON_WIN_CAT_TIPO_PROD tp " + 
			"         ON p.tipo_producto = tp.id " + 
			" INNER JOIN PAP_MON_WIN_CAT_MARCA m " + 
			"         ON p.marca = m.id " + 
			"      WHERE p.status = 1 " + 
			"        AND tp.status = 1" + 
			"   GROUP BY m.id;", nativeQuery = true)
	List<Object[]> listarTipoProductoAgrupado();
}