/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.model.SucursalProducto;
import com.papeleria.del.istmo.mowin.repository.ISucursalProductoRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 28 oct. 2020
 *
 * Descripcion: Clase SucursalProductoService.java creada para 
 * 
 */
@Service
public class SucursalProductoService implements ISucursalProductoService {

	/**
	 * Variable iSucursalProductoRepository de tipo  ISucursalProductoRepository
	 */
	@Autowired
	private ISucursalProductoRepository iSucursalProductoRepository;
	
	@Override
	public List<SucursalProducto> obtenerSucursalProductoByIdSucursal(int idSucursal) throws ServiceException {
		return this.iSucursalProductoRepository.obtenerSucursalProductoByIdSucursal(idSucursal);
	}

	@Override
	public SucursalProducto guardar(SucursalProducto sucursalProducto) throws ServiceException {
		return this.iSucursalProductoRepository.save(sucursalProducto);
	}

	@Override
	public int eliminarById(int id) throws ServiceException {
		Optional<SucursalProducto> sucursalProducto = this.iSucursalProductoRepository.findById(id);
		if(sucursalProducto.isPresent()) {
			this.iSucursalProductoRepository.delete(sucursalProducto.get());
			return 1;
		}
		return 0;
	}

}
