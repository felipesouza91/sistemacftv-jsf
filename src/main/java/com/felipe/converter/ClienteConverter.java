package com.felipe.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.felipe.model.Cliente;
import com.felipe.repository.ClienteRepository;
import com.felipe.util.Repositorios;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {
	private Repositorios repositorios = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		Cliente retorno = null;
		ClienteRepository clienteDao = repositorios.getCliente();
		if (value != null && !value.equals("")) {
			retorno = clienteDao.getPorCodigo(Integer.parseInt(value));

			if (retorno == null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente não existe", "Lancamento não existe");
				throw new ConverterException(msg);
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		if (value != null) {
			Integer id = ((Cliente) value).getId();
			return id == null ? "" : id.toString();
		}
		return null;
	}

}
