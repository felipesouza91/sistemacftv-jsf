package com.felipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.felipe.model.Dvr;
import com.felipe.repository.DvrRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = Dvr.class)
public class DvrConverter implements Converter {
	private Repositorios repositorio = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		Dvr retorno = null;
		DvrRepository dvrDao = repositorio.getDvr();
		if (!value.equals("")) {
			if (value != null) {
				try {
					retorno = dvrDao.getPorCodigo(Integer.parseInt(value));

				} catch (Exception e) {
					retorno = null;
				}

			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		if (value != null) {
			Integer id = ((Dvr) value).getId();
			return id == null ? null : id.toString();
		}
		return null;
	}

}
