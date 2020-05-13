package com.felipe.validadores;

import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("com.felipe.validadores.dataFechamento")
public class DataFechamentoOsValidador implements Validator {

	private Date getDataHoje() {
		return Calendar.getInstance().getTime();
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Date date = (Date) value;
		Object label = MessageFactory.getLabel(context, component);
		if (date != null && date.after(getDataHoje())) {
			String desc = label + "não pode ser depois que hoje";
		}

	}

}
