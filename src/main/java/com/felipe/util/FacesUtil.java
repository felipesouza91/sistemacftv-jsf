package com.felipe.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {

	private FacesUtil() {}

	public static void addMensagem(Severity serv, String msg) {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage facesMsg = new FacesMessage(serv, msg, msg);
		
		context.addMessage(null, facesMsg);
	}


	public static void addMensagem(String clientId, Severity serv, String msg) {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage facesMsg = new FacesMessage(serv, msg, msg);

		context.addMessage(clientId, facesMsg);
	}

	public static Object getRequestAttribute(String nome) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute(nome);
	}

}
