/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IUsuarioRolRepository.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 7 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 7 feb. 2020 Herwin: Creacion de la clase
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

import com.papeleria.del.istmo.mowin.model.UsuarioRol;
import com.papeleria.del.istmo.mowin.model.UsuarioRolPK;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> IUsuarioRolRepository.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 7 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 7 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
public interface IUsuarioRolRepository extends CrudRepository<UsuarioRol, UsuarioRolPK>{

	@Modifying
	@Query(value = "Delete from mv_usuario_rol where id_usuario = :idUsuario and id_rol =:idRol ", nativeQuery = true)
	void eliminarUsuarioRol(@Param("idUsuario") String idUsuario, @Param("idRol") int idRol);
	
	
	@Modifying
	@Query(value = "Insert into mv_usuario_rol ( id_usuario, id_rol)  values (:idUsuario , :idRol)", nativeQuery = true)
	void guardarUsuarioRol(@Param("idUsuario") String idUsuario, @Param("idRol") int idRol);
	
	
	@Query(value = "select u.* from PAP_MON_WIN_CAT_USUARIO u left join mv_usuario_rol ur on u.id = ur.id_usuario where ur.id_rol is null; ", nativeQuery = true)
	List<Object[]> obtenerUsuariosNoAsignados();
	
	@Query(value = "select r.id, r.descripcion from PAP_MON_WIN_CAT_USUARIO u left join mv_usuario_rol ur on u.id = ur.id_usuario left join mv_rol r on ur.id_rol = r.id where ur.id_usuario = :idUsuario ", nativeQuery = true)
	List<Object[]> obtenerUsuario(@Param("idUsuario") String idUsuario);

}
