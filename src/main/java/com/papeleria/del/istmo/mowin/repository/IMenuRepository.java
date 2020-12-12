/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IMenuRepository.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 19, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 19, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.papeleria.del.istmo.mowin.model.Menu;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IMenuRepository.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 19, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 19, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
public interface IMenuRepository extends CrudRepository<Menu, Integer>{
	
	@Query(value = "select m.* from mv_menu_rol mr inner join mv_usuario_rol ur on ur.id_rol = mr.id_rol inner join mv_menu m on m.id = mr.id_menu inner join PAP_MON_WIN_CAT_USUARIO u on u.id = ur.id_usuario where u.correo = :correo", nativeQuery = true)
	List<Object[]> listarMenuByCorreo(@Param("correo") String correo);
	
	@Query(value = "select m.* from mv_menu_rol mr inner join mv_usuario_rol ur on ur.id_rol = mr.id_rol inner join mv_menu m on m.id = mr.id_menu inner join PAP_MON_WIN_CAT_USUARIO u on u.id = ur.id_usuario where u.id = :idUsuario and m.padre is null", nativeQuery = true)
	List<Object[]> listarMenuByIdUsuario(@Param("idUsuario") String idUsuario);
	
	@Query(value = "select m.* from mv_menu_rol mr  inner join mv_usuario_rol ur  on ur.id_rol = mr.id_rol  inner join mv_menu m on m.id = mr.id_menu  inner join PAP_MON_WIN_CAT_USUARIO u on u.id = ur.id_usuario  where u.id = :idUsuario and m.padre = :idPadre", nativeQuery = true)
	List<Object[]> listarMenuByIdUsuarioChild(@Param("idUsuario") String idUsuario, @Param("idPadre") int idPadre);
	
	@Modifying
	@Query(value = "Insert into mv_menu_rol(id_menu, id_rol) values (:idMenu, :idRol) ", nativeQuery = true)
	int crearMenuRol(@Param("idMenu") int idMenu, @Param("idRol") int idRol);
	
	@Modifying
	@Query(value = "Delete from mv_menu_rol where id_menu = :idMenu and id_rol =:idRol ", nativeQuery = true)
	void eliminarMenuRol(@Param("idMenu") int idMenu, @Param("idRol") int idRol);
	
	@Modifying
	@Query(value = "Delete from mv_menu_rol where id_rol =:idRol ", nativeQuery = true)
	void eliminarMenuRolByIdRol(@Param("idRol") int idRol);
	
	@Query(value = "Select m.id as idmenu, m.nombre, m.icono, m.url, r.id as idrol, r.descripcion from mv_menu_rol mr inner join mv_menu m on m.id = mr.id_menu inner join mv_rol r on r.id = mr.id_rol order by m.nombre asc", nativeQuery = true)
	List<Object[]> obtenerListaMenuRoles();
	
	@Query(value = "Select m.id as idmenu, m.nombre, m.icono, m.url, r.id as idrol, r.descripcion from mv_menu_rol mr inner join mv_menu m on m.id = mr.id_menu inner join mv_rol r on r.id = mr.id_rol where mr.id_rol = :idRol order by m.nombre asc", nativeQuery = true)
	List<Object[]> obtenerListaMenuRoles(@Param("idRol") int idRol);
	
	@Query("Select m From Menu m order by m.nombre asc")
	List<Menu> obtenerMenus();
	
	@Query("Select m From Menu m where m.id != :idMenu and m.padre is null order by m.nombre asc")
	List<Menu> obtenerMenusPadres(@Param("idMenu") int idMenu);
}
