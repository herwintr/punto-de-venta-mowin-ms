/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> RolService.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 9 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 9 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.model.Rol;
import com.papeleria.del.istmo.mowin.repository.IRolRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> RolService.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 9 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 9 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@Service
public class RolService implements IRolService {

	@Autowired
	private IRolRepository iRolRepository;
	
	@Override
	public Rol crearRol(Rol rol) throws ServiceException{
		return this.iRolRepository.save(rol);
	}

	@Override
	public List<Rol> leerRol() throws ServiceException{
		return (List<Rol>) this.iRolRepository.findAll();
	}

	@Override
	public Rol actualizarRol(Rol rol) throws ServiceException{
		return this.iRolRepository.save(rol);
	}

	@Override
	public int eliminarRol(int  idRol) throws ServiceException{
		if(this.iRolRepository.existsById(idRol)) {
			this.iRolRepository.deleteById(idRol);
			return 1;
		}
		return 0;
	}

	@Override
	public Rol consultaRol(int id) throws ServiceException {
		Optional<Rol> rolConsultado = this.iRolRepository.findById(id);
		if(rolConsultado.isPresent()) {
			return rolConsultado.get();
		}
		return null;
	}

}
