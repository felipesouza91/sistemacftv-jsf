package com.felipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.felipe.model.MotivoOs;
import com.felipe.repository.MontivoOsRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = MotivoOs.class)
public class MotivoOsConverter implements Converter {
	private Repositorios repositorio = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		MotivoOs retorno = null;
		MontivoOsRepository motivoOsDao = repositorio.getMotivoOss();
		if (!value.equals("")) {
			if (value != null) {
				retorno = motivoOsDao.getPorCodigo(new Integer(value));
			}
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		if (value != null) {
			Integer id = ((MotivoOs) value).getId();
			return id == null ? null : id.toString();
		}
		return null;
	}

}
