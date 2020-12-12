/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.model.SucursalUsuario;
import com.papeleria.del.istmo.mowin.repository.ISucursalUsuarioRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 28 oct. 2020
 *
 * Descripcion: Clase SucursalUsuarioService.java creada para 
 * 
 */
@Service
public class SucursalUsuarioService implements ISucursalUsuarioService {

	/**
	 * Variable iSucursalUsuarioRepository de tipo  ISucursalUsuarioRepository
	 */
	@Autowired
	private ISucursalUsuarioRepository iSucursalUsuarioRepository;
	
	@Override
	public List<SucursalUsuario> obtenerSucursalUsuarioByIdSucursal(int idSucursal) throws ServiceException {
		return this.iSucursalUsuarioRepository.obtenerSucursalUsuarioByIdSucursal(idSucursal);
	}

	@Override
	public SucursalUsuario guardar(SucursalUsuario sucursalUsuario) throws ServiceException {
		return this.iSucursalUsuarioRepository.save(sucursalUsuario);
	}

	@Override
	public int eliminarById(int id) throws ServiceException {
		Optional<SucursalUsuario> sucursalUsuario = this.iSucursalUsuarioRepository.findById(id);
		if(sucursalUsuario.isPresent()) {
			this.iSucursalUsuarioRepository.delete(sucursalUsuario.get());
			return 1;
		}
		return 0;
	}

}
