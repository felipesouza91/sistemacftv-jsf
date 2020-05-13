package com.felipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.felipe.model.FechamentoOs;
import com.felipe.repository.FechamentoOsRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = FechamentoOs.class)
public class FechamentoOsConverter implements Converter {
	private Repositorios rep = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		FechamentoOsRepository fechamentoDao = rep.getFechamentoOs();
		FechamentoOs retorno = null;
		if (value != null && !value.equals("")) {
			retorno = fechamentoDao.getPorCodigo(Integer.parseInt(value));

		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		if (value != null) {
			Integer id = ((FechamentoOs) value).getId();
			return id == null ? "" : id.toString();
		}
		return null;
	}

}
