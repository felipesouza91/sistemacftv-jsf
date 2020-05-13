package com.felipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.felipe.model.VerificacaoGravacao;
import com.felipe.repository.VerificacaoGravacaoRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = VerificacaoGravacao.class)
public class VerificacaoGravacaoConverter implements Converter {

	private Repositorios rep = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {

		VerificacaoGravacao retorno = null;
		VerificacaoGravacaoRepository gravacao = rep.getVerificacaoGravacao();
		if (value != null) {
			retorno = gravacao.getPorCodigo(new Integer(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {

		if (value != null) {
			Integer id = ((VerificacaoGravacao) value).getId();
			return id == null ? null : id.toString();
		}
		return null;
	}

}
