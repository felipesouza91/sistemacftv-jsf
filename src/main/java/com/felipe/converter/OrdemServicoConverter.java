package com.felipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.felipe.model.OrdemServico;
import com.felipe.repository.OrdemServicoRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = OrdemServico.class)
public class OrdemServicoConverter implements Converter {

	Repositorios repositorios = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		OrdemServico retorno = null;
		OrdemServicoRepository osDao = repositorios.getOs();
		if (value != null) {
			retorno = osDao.getPorCodigo(new Integer(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		String id = null;
		if (value != null && !value.equals("null")) {
			try {
				id = ((OrdemServico) value).getId().toString();
			} catch (Exception e) {
				id = null;
			}
		}
		return id;
	}

}
