package com.felipe.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.felipe.converter.dataHtml5")
public class DataConveterHtml5 implements Converter {

	private final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		Date c = null;
		try {
			c = sdf.parse(value);

		} catch (Exception e) {
			c = null;
		}
		return c;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		return sdf.format((Date) value);
	}

}
