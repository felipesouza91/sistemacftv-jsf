package com.felipe.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.felipe.converter.dataConverter")
public class DataConverter implements Converter {

	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {

		Date c = null;
		try {
			c = sdf.parse(value);
			return c;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		return sdf.format((Date) value);
	}

}
