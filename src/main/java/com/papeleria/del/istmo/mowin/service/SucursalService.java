/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.model.Sucursal;
import com.papeleria.del.istmo.mowin.repository.ISucursalRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 28 oct. 2020
 *
 * Descripcion: Clase SucursalService.java creada para 
 * 
 */
@Service
public class SucursalService implements ISucursalService {

	/**
	 * Variable iSucursalRepository de tipo  ISucursalRepository
	 */
	@Autowired
	private ISucursalRepository iSucursalRepository;
	
	@Override
	public List<Sucursal> obtenerSucursal() throws ServiceException {
		return (List<Sucursal>) this.iSucursalRepository.findAll();
	}

	@Override
	public Sucursal guardar(Sucursal sucursal) throws ServiceException {
		return this.iSucursalRepository.save(sucursal);
	}

	@Override
	public Sucursal consultaById(int id) throws ServiceException {
		Optional<Sucursal> sucursal = this.iSucursalRepository.findById(id);
		if(sucursal.isPresent()) {
			return sucursal.get();
		}
		return new Sucursal();
	}

	@Override
	public int eliminarById(int id) throws ServiceException {
		Optional<Sucursal> sucursal = this.iSucursalRepository.findById(id);
		if(sucursal.isPresent()) {
			this.iSucursalRepository.delete(sucursal.get());
			return 1;
		}
		return 0;
	}

}
