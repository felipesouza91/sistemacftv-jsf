package com.felipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.felipe.model.Cidade;
import com.felipe.repository.CidadeRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {
	private Repositorios repositorios = new Repositorios();
	private CidadeRepository cidadeDao = repositorios.getCidade();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		Cidade retorno = null;
		if (value != null) {
			retorno = cidadeDao.getPorCodigo(Integer.parseInt(value));
			return retorno;
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		if (value != null) {
			return ((Cidade) value).getId().toString();
		}
		return null;
	}

}
