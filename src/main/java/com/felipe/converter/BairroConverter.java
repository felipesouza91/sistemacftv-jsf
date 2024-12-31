package com.felipe.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.felipe.model.Bairro;
import com.felipe.repository.BairroRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = Bairro.class)
public class BairroConverter implements Converter {

	private Repositorios repositorio = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		Bairro retorno = null;
		BairroRepository bairroDao = repositorio.getBairro();
		if (value != null) {
			retorno = bairroDao.getPorCodigo(Integer.parseInt(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext contexte, UIComponent componet, Object value) {
		if (value != null) {
			return ((Bairro) value).getId().toString();
		}
		return null;
	}

}
