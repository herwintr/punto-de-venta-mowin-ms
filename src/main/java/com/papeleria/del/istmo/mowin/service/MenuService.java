package com.papeleria.del.istmo.mowin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.del.istmo.mowin.dto.MenuDTO;
import com.papeleria.del.istmo.mowin.dto.MenusRolesDTO;
import com.papeleria.del.istmo.mowin.dto.NavItemDTO;
import com.papeleria.del.istmo.mowin.dto.RolDTO;
import com.papeleria.del.istmo.mowin.model.Menu;
import com.papeleria.del.istmo.mowin.repository.IMenuRepository;
import com.papeleria.del.istmo.mowin.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MenuService.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created Feb 20, 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 Feb 20, 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@Service @Transactional
public class MenuService implements IMenuService {
	
	/**
	 * iMenuRepository variable de tipo IMenuRepository 
	 */
	@Autowired
	private IMenuRepository iMenuRepository;

	@Override
	public List<MenuDTO> obtenerMenuByCorreo(String correo) throws ServiceException {
		List<MenuDTO> listaMenu = new ArrayList<MenuDTO>();
		this.iMenuRepository.listarMenuByCorreo(correo).forEach(x -> {
			MenuDTO menu = new MenuDTO();
			menu.setIcono(String.valueOf(x[1]));
			menu.setNombre(String.valueOf(x[2]));
			menu.setUrl(String.valueOf(x[3]));
			listaMenu.add(menu);
		});
		return listaMenu;
	}
	
	@Override
	public List<NavItemDTO> obtenerMenuByUsuario(String usuario) throws ServiceException {
		List<NavItemDTO> listaMenu = new ArrayList<NavItemDTO>();
//		List<MenuDTO> listaMenu = new ArrayList<MenuDTO>();
		
		this.iMenuRepository.listarMenuByIdUsuario(usuario).forEach(x -> {
			/*MenuDTO menu = new MenuDTO();
			menu.setId(Integer.parseInt(String.valueOf(x[0])));
			menu.setIcono(String.valueOf(x[1]));
			menu.setNombre(String.valueOf(x[2]));
			menu.setUrl(String.valueOf(x[3]));*/
			NavItemDTO menu = new NavItemDTO();
			menu.setDisabled(false);
			menu.setIconName(String.valueOf(x[1]));
			menu.setDisplayName(String.valueOf(x[2]));
			menu.setRoute(String.valueOf(x[3]));
			
			menu.setChildren(obtenerMenusHijosByList(this.iMenuRepository.listarMenuByIdUsuarioChild(usuario, Integer.parseInt(String.valueOf(x[0])))));
			listaMenu.add(menu);
		});
		return listaMenu;
	}

	@Override
	public List<MenuDTO> obtenerMenu() throws ServiceException {
		List<MenuDTO> listaMenu = new ArrayList<MenuDTO>();
		this.iMenuRepository.obtenerMenus().forEach(x -> {
			MenuDTO menu = new MenuDTO();
			menu.setId(x.getId());
			menu.setIcono(x.getIcono());
			menu.setNombre(x.getNombre());
			menu.setUrl(x.getUrl());
			if(x.getPadre()!=null) {
				MenuDTO menuPadre = new MenuDTO();
				menuPadre.setId(x.getPadre().getId());
				menuPadre.setIcono(x.getPadre().getIcono());
				menuPadre.setNombre(x.getPadre().getNombre());
				menuPadre.setUrl(x.getPadre().getUrl());
				menu.setPadre(menuPadre);
			}
			listaMenu.add(menu);
		});
		return listaMenu;
	}	
	
	@Override
	public List<MenuDTO> obtenerMenuPadres(int idMenu) throws ServiceException {
		List<MenuDTO> listaMenu = new ArrayList<MenuDTO>();
		this.iMenuRepository.obtenerMenusPadres(idMenu).forEach(x -> {
			MenuDTO menu = new MenuDTO();
			menu.setId(x.getId());
			menu.setIcono(x.getIcono());
			menu.setNombre(x.getNombre());
			menu.setUrl(x.getUrl());
			listaMenu.add(menu);
		});
		return listaMenu;
	}	
	
	private List<NavItemDTO> obtenerMenusHijosByList(List<Object[]> menuHijo){
		List<NavItemDTO> listaHijos = new ArrayList<NavItemDTO>();
		menuHijo.forEach(x -> {
			/*MenuDTO menu = new MenuDTO();
			menu.setId(Integer.parseInt(String.valueOf(x[0])));
			menu.setIcono(String.valueOf(x[1]));
			menu.setNombre(String.valueOf(x[2]));
			menu.setUrl(String.valueOf(x[3]));*/
			NavItemDTO menu = new NavItemDTO();
			menu.setDisabled(false);
			menu.setIconName(String.valueOf(x[1]));
			menu.setDisplayName(String.valueOf(x[2]));
			menu.setRoute(String.valueOf(x[3]));
			listaHijos.add(menu);
		});
		return listaHijos;
	}
	
	@Override
	public MenuDTO guardar(Menu menu) throws ServiceException {
		Menu menuSave = this.iMenuRepository.save(menu);
		
		MenuDTO menuDto = new MenuDTO();
		menuDto.setId(menuSave.getId());
		menuDto.setIcono(menuSave.getIcono());
		menuDto.setNombre(menuSave.getNombre());
		menuDto.setUrl(menuSave.getUrl());
		return menuDto;
	}

	@Override
	public Menu consultaById(int id) throws ServiceException {
		Optional<Menu> optionalA = this.iMenuRepository.findById(id);
		if(optionalA.isPresent()){
			return optionalA.get();
		}
		return null;
	}

	@Override
	public int eliminarById(int id) throws ServiceException {
		if(this.iMenuRepository.existsById(id)) {
			this.iMenuRepository	.deleteById(id);
			return 1;
		}
		return 0;
	}

	@Override
	public int crearMenuRol(List<MenusRolesDTO> listaMenuRoles) throws ServiceException {
		for(MenusRolesDTO menuRol : listaMenuRoles) {
			this.iMenuRepository.crearMenuRol(menuRol.getMenu().getId(), menuRol.getRol().getId());
		}
		return 1;
	}

	@Override
	public int eliminarMenuRol(int idMenu, int idRol) throws ServiceException {
		
		this.iMenuRepository.eliminarMenuRol(idMenu, idRol);
		
		return 1;
	}
	
	@Override
	public List<MenusRolesDTO> obtenerMenuRol() throws ServiceException {
		List<MenusRolesDTO> listaMenuRol = new ArrayList<MenusRolesDTO>();
		this.iMenuRepository.obtenerListaMenuRoles().forEach(x -> {
			MenusRolesDTO menuRol = new MenusRolesDTO();
			MenuDTO menu = new MenuDTO();
			menu.setId(Integer.parseInt(String.valueOf(x[0])));
			menu.setNombre(String.valueOf(x[1]));
			menu.setIcono(String.valueOf(x[2]));
			menu.setUrl(String.valueOf(x[3]));
			
			RolDTO rol = new RolDTO();
			rol.setId(Integer.parseInt(String.valueOf(x[4])));
			rol.setDescripcion(String.valueOf(x[5]));
			menuRol.setMenu(menu);
			menuRol.setRol(rol);
			listaMenuRol.add(menuRol);
		});
		return listaMenuRol;
	}

	@Override
	public List<MenusRolesDTO> obtenerMenuRol(int idRol) throws ServiceException {
		List<MenusRolesDTO> listaMenuRol = new ArrayList<MenusRolesDTO>();
		this.iMenuRepository.obtenerListaMenuRoles(idRol).forEach(x -> {
			MenusRolesDTO menuRol = new MenusRolesDTO();
			MenuDTO menu = new MenuDTO();
			menu.setId(Integer.parseInt(String.valueOf(x[0])));
			menu.setNombre(String.valueOf(x[1]));
			menu.setIcono(String.valueOf(x[2]));
			menu.setUrl(String.valueOf(x[3]));
			
			RolDTO rol = new RolDTO();
			rol.setId(Integer.parseInt(String.valueOf(x[4])));
			rol.setDescripcion(String.valueOf(x[5]));
			menuRol.setMenu(menu);
			menuRol.setRol(rol);
			listaMenuRol.add(menuRol);
		});
		return listaMenuRol;
	}

	@Override
	public int eliminarMenuRolByIdRol(int idRol) throws ServiceException {
			
		this.iMenuRepository.eliminarMenuRolByIdRol(idRol);
		
		return 1;
	}
}
