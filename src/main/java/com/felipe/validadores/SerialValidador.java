package com.felipe.validadores;

import java.util.ArrayList;

import com.felipe.model.Dvr;

import com.felipe.repository.DvrRepository;
import com.felipe.util.Repositorios;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.felipe.validadores.serialValidador")
public class SerialValidador implements Validator {

	Repositorios rep = new Repositorios();

	@Override
	public void validate(FacesContext context, UIComponent componet, Object value) throws ValidatorException {
		String serial = (String) value;
		DvrRepository dvrDao = rep.getDvr();
		ArrayList<Dvr> buscaSerial = (ArrayList) dvrDao.getporSerial(serial);
		if (serial != null && !buscaSerial.isEmpty()) {
			String msg = "O serial já esta sendo utilizado no cliente: " + buscaSerial.get(0).getCliente().getFantazia()
					+ " !";
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
			throw new ValidatorException(fmsg);
		}

	}

}
