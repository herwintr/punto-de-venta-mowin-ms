/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioRolService.java
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
package com.papeleria.del.istmo.mowin.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.dto.RolDTO;
import com.papeleria.del.istmo.mowin.dto.UsuarioDTO;
import com.papeleria.del.istmo.mowin.dto.UsuarioRolDTO;
import com.papeleria.del.istmo.mowin.model.Rol;
import com.papeleria.del.istmo.mowin.model.Usuario;
import com.papeleria.del.istmo.mowin.model.UsuarioRol;
import com.papeleria.del.istmo.mowin.repository.IUsuarioRolRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioRolService.java
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
@Service @Transactional
public class UsuarioRolService implements IUsuarioRolService {

	/**
	 * iUsuarioRolRepository variable de tipo IUsuarioRolRepository 
	 */
	@Autowired
	private IUsuarioRolRepository iUsuarioRolRepository;
	
	/**
	 * obtener lista de usuarios y roles asignados
	 * 
	 * @return lista usuarios roles 
	 * 
	 * @throws ServiceException - en caso de ocurrir un error se lanza un serviceException
	 */
	@Override
	public List<UsuarioRolDTO> getListaUsuarioRol() throws ServiceException {
		return getUsuarios((List<UsuarioRol>) this.iUsuarioRolRepository.findAll());
	}
	
	@Override
	public int save(UsuarioRol usuarioRol) throws ServiceException {
		this.iUsuarioRolRepository.eliminarUsuarioRol(usuarioRol.getUsuario().getId(), usuarioRol.getRol().getId());
		this.iUsuarioRolRepository.guardarUsuarioRol(usuarioRol.getUsuario().getId(), usuarioRol.getRol().getId());
		return 1;
	}

	@Override
	public int eliminarUsuarioRol(String idUsuario, int idRol) throws ServiceException {
		this.iUsuarioRolRepository.eliminarUsuarioRol(idUsuario, idRol);
		return 0;
	}
	
	@Override
	public List<UsuarioDTO> getListaUsuarioRolNoAsignados() throws ServiceException {
		List<UsuarioDTO> listaDto = new ArrayList<UsuarioDTO>();
		this.iUsuarioRolRepository.obtenerUsuariosNoAsignados().forEach(x -> {
			UsuarioDTO usuarioDto = new UsuarioDTO();
			usuarioDto.setId(String.valueOf(x[0]));
			usuarioDto.setApellidos(String.valueOf(x[2]));
			usuarioDto.setCorreo(String.valueOf(x[4]));
			usuarioDto.setEncargado(Boolean.parseBoolean(String.valueOf(x[5])));
			usuarioDto.setNombre(String.valueOf(x[6]));
			usuarioDto.setPassword(String.valueOf(x[7]));
			
			listaDto.add(usuarioDto);
		});
		return listaDto;
		
	}
	
	@Override
	public RolDTO getListaUsuarioByIdUser(String idUsuario) throws ServiceException {
		RolDTO rol = new RolDTO();
		this.iUsuarioRolRepository.obtenerUsuario(idUsuario).forEach(x -> {
			rol.setId(Integer.parseInt(String.valueOf(x[0])));
			rol.setDescripcion(String.valueOf(x[1]));
		});
		return rol;
	}
	
	private List<UsuarioRolDTO> getUsuarios(List<UsuarioRol> listaUsuarioRol){
		List<UsuarioRolDTO> listaUsuarioDto = new ArrayList<UsuarioRolDTO>();
		for(UsuarioRol uRol : listaUsuarioRol) {
			listaUsuarioDto.add(getUsuarioRol(uRol));
		}
		return listaUsuarioDto;
	}

	private UsuarioRolDTO getUsuarioRol(UsuarioRol usuarioRol) {
		UsuarioRolDTO usuarioDtoRol = new UsuarioRolDTO();
		usuarioDtoRol.setUsuario(getUsuario(usuarioRol.getUsuario()));
		usuarioDtoRol.setRol(getRolDto(usuarioRol.getRol()));
		return usuarioDtoRol;
	}
	
	private UsuarioDTO getUsuario(Usuario usuario) {
		UsuarioDTO usuarioDto = new UsuarioDTO();
		usuarioDto.setStatus(usuario.getStatus());
		usuarioDto.setApellidos(usuario.getApellidos());
		usuarioDto.setCorreo(usuario.getCorreo());
		usuarioDto.setId(usuario.getId()+"");
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setPassword(usuario.getPassword());
		return usuarioDto;
	}
	
	private RolDTO getRolDto(Rol rol) {
		RolDTO rolDto = new RolDTO();
		rolDto.setDescripcion(rol.getDescripcion());
		rolDto.setId(rol.getId());
		return rolDto;
	}

}