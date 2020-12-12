/**
 * 
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.model.Color;
import com.papeleria.del.istmo.mowin.repository.IColorRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Papeleria Mowin
 * Version 1.0
 * 
 * Creado por: HTR
 * Fecha Creacion: 26 oct. 2020
 *
 * Descripcion: Clase ColorService.java creada para 
 * 
 */
@Service
public class ColorService implements IColorService {

	/**
	 * Variable iColorRepository de tipo  IColorRepository
	 */
	@Autowired
	private IColorRepository iColorRepository;
	
	@Override
	public List<Color> obtenerComponentes() throws ServiceException {
		return (List<Color>) this.iColorRepository.findAllOrderByDescripcion();
	}

	@Override
	public Color guardar(Color color) throws ServiceException {
		return this.iColorRepository.save(color);
	}

	@Override
	public Color consultaById(int id) throws ServiceException {
		Optional<Color> color = this.iColorRepository.findById(id);
		if(color.isPresent()) {
			return color.get();
		}
		return new Color();
	}

	@Override
	public int eliminarById(int id) throws ServiceException {
		Optional<Color> color = this.iColorRepository.findById(id);
		if(color.isPresent()) {
			this.iColorRepository.delete(color.get());
			return 1;
		}
		return 0;
	}

}
