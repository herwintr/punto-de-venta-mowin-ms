/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.model.Descuento;
import com.papeleria.del.istmo.mowin.repository.IDescuentoRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 26 oct. 2020
 *
 * Descripcion: Clase DescuentoService.java creada para 
 * 
 */
@Service
public class DescuentoService implements IDescuentoService {

	/**
	 * Variable iDescuentoRepository de tipo  IDescuentoRepository
	 */
	@Autowired
	private IDescuentoRepository iDescuentoRepository;
	
	@Override
	public List<Descuento> obtenerComponentes() throws ServiceException {
		return (List<Descuento>) this.iDescuentoRepository.findAll();
	}

	@Override
	public Descuento guardar(Descuento descuentos) throws ServiceException {
		return this.iDescuentoRepository.save(descuentos);
	}

	@Override
	public Descuento consultaById(int id) throws ServiceException {
		Optional<Descuento> descuento = this.iDescuentoRepository.findById(id);
		if(descuento.isPresent()) {
			return descuento.get();
		}
		return new Descuento();
	}

	@Override
	public int eliminarById(int id) throws ServiceException {
		Optional<Descuento> descuento = this.iDescuentoRepository.findById(id);
		if(descuento.isPresent()) {
			this.iDescuentoRepository.delete(descuento.get());
			return 1;
		}
		return 0;
	}

}
