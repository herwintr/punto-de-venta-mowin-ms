/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioService.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 5 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.dto.RolDTO;
import com.papeleria.del.istmo.mowin.dto.UsuarioDTO;
import com.papeleria.del.istmo.mowin.model.Descuento;
import com.papeleria.del.istmo.mowin.model.Rol;
import com.papeleria.del.istmo.mowin.model.Usuario;
import com.papeleria.del.istmo.mowin.model.UsuarioRol;
import com.papeleria.del.istmo.mowin.repository.IUsuarioRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> UsuarioService.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 5 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@Service
public class UsuarioService implements IUsuarioService {

	/**
	 * iUsuarioRepository variable de tipo IUsuarioRepository 
	 */
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	/**
	 * Variable iUsuarioRolService de tipo  IUsuarioRolService
	 */
	@Autowired
	private IUsuarioRolService iUsuarioRolService;
	
	/**
	 * Variable iRolService de tipo  IRolService
	 */
	@Autowired
	private IRolService iRolService;
	
	/**
	 * Variable iRolService de tipo  IRolService
	 */
	@Autowired
	private IDescuentoService iDescuentoService;
	
	/**
	 * Obtener lista de usuarios almacenados en base de datos
	 * 
	 * @return {@link lista de usuarios}
	 */
	@Override
	public List<UsuarioDTO> findAll()  throws ServiceException{
		return obtenerDatos((List<Usuario>) this.iUsuarioRepository.findAll());
	}

	/**
	 * guardado de usuario a base de datos
	 * 
	 * @param usuario - objeto usuario a almacenar a base de datos
	 * @return objeto alamcenado en base 
	 */
	@Override
	public Usuario save(UsuarioDTO usuario) throws ServiceException{
		
		Usuario userSave = this.obtenerUsuarioById(usuario.getId());
		if(userSave == null) {
			userSave = new Usuario(); 
		}
		userSave.setId(usuario.getId());
		userSave.setNombre(usuario.getNombre());
		userSave.setApellidos(usuario.getApellidos());
		userSave.setCorreo(usuario.getCorreo());
		userSave.setFb(usuario.getFb());
		userSave.setTw(usuario.getTw());
		userSave.setUsuario(usuario.getUsuario());
		userSave.setTel(usuario.getTel());
		userSave.setDireccion(usuario.getDireccion());
		userSave.setPassword(usuario.getPassword());
		userSave.setRfc(usuario.getRfc());
		userSave.setStatus(usuario.getStatus());
		LocalDateTime fechaActual = LocalDateTime.now();
		userSave.setFechaRegistro(fechaActual);
		userSave.setEncargado(usuario.isEncargado());
		Descuento descuento = this.iDescuentoService.consultaById(usuario.getDescuento().getId());
		userSave.setDescuento(descuento);
		Usuario usuarioRegistrado = this.iUsuarioRepository.save(userSave);
		Rol rolBase = this.iRolService.consultaRol(usuario.getRol().getId());
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rolBase);
		usuarioRol.setUsuario(usuarioRegistrado);
		this.iUsuarioRolService.save(usuarioRol);
		return usuarioRegistrado;
	}
	
	/**
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@Override
	public UsuarioDTO loginUsuario(String userName, String passWord) throws ServiceException {
		Usuario usuario = this.iUsuarioRepository.obtenerUsuarioLogin(userName, passWord);
		return getUsuarioDTO(usuario);
	}

	/**
	 * @param usuario - usuario a actualizar
	 * @return objeto alamcenado en base
	 */
	@Override
	public Usuario update(Usuario usuario) throws ServiceException{
		return this.iUsuarioRepository.save(usuario);
	}
	
	/**
	 * @param usuario - usuario a actualizar
	 * @return objeto alamcenado en base
	 */
	@Override
	public int eliminar(String id) throws ServiceException{
		if(this.iUsuarioRepository.existsById(id)) {
			this.iUsuarioRepository.deleteById(id);
			return 1;
		}
		return 0;
	}
	
	/**
	 * @param listaUsuario
	 * @return
	 */
	private List<UsuarioDTO> obtenerDatos(List<Usuario> listaUsuario){
		List<UsuarioDTO> listaUsuarioDTO = new ArrayList<UsuarioDTO>();
		for(Usuario usuario : listaUsuario) {
			UsuarioDTO usuarioDto = getUsuarioDTO(usuario);
			usuarioDto.setSubordinados(getUsuarios(usuario.getSubordinados()));
			usuarioDto.setJefe(getUsuarioDTO(usuario.getJefe()));
			listaUsuarioDTO.add(usuarioDto);
		}
		
		return listaUsuarioDTO;
	}
	
	/**
	 * @param listaUsuario
	 * @return
	 */
	private List<UsuarioDTO> getUsuarios(List<Usuario> listaUsuario){
		List<UsuarioDTO> listaUsuarioDto = new ArrayList<UsuarioDTO>();
		for(Usuario user : listaUsuario) {
			listaUsuarioDto.add(getUsuarioDTO(user));
		}
		return listaUsuarioDto;
	}
	
	/**
	 * @param usuario
	 * @return
	 */
	private UsuarioDTO getUsuarioDTO(Usuario usuario) {
		if(usuario == null) {
			return null;
		}

		UsuarioDTO usuarioDto = new UsuarioDTO();
		usuarioDto.setId(usuario.getId());
		usuarioDto.setStatus(usuario.getStatus());
		usuarioDto.setUsuario(usuario.getUsuario());
		usuarioDto.setApellidos(usuario.getApellidos());
		usuarioDto.setCorreo(usuario.getCorreo());
		usuarioDto.setFb(usuario.getFb());
		usuarioDto.setTw(usuario.getTw());
		usuarioDto.setTel(usuario.getTel());
		usuarioDto.setDescuento(usuario.getDescuento());
		usuarioDto.setDireccion(usuario.getDireccion());
		usuarioDto.setFechaCreacion(usuario.getFechaRegistro().toString());
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setPassword(usuario.getPassword());
		usuarioDto.setEncargado(usuario.isEncargado());
		try {
			RolDTO rol = this.iUsuarioRolService.getListaUsuarioByIdUser(usuario.getId());
			usuarioDto.setRol(rol);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return usuarioDto;
	}

	@Override
	public List<UsuarioDTO> findAllLideres() throws ServiceException {
		return obtenerDatos(this.iUsuarioRepository.obtenerUsuariosLideres());
	}

	@Override
	public Usuario obtenerUsuarioById(String id) throws ServiceException {
		Optional<Usuario> rolConsultado = this.iUsuarioRepository.findById(id);
		if(rolConsultado.isPresent()) {
			return rolConsultado.get();
		}
		return null;
	}
}