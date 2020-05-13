package com.felipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.felipe.model.Usuario;
import com.felipe.repository.UsuarioRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	private Repositorios rep = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		Usuario retorno = null;
		UsuarioRepository usuarioDao = rep.getUsuario();
		if (value != null) {
			retorno = usuarioDao.getPorCodigo(Integer.parseInt(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		if (value != null) {
			Integer id = ((Usuario) value).getId();
			return id == null ? null : id.toString();
		}
		return null;
	}

}
