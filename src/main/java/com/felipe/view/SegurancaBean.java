package com.felipe.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
public class SegurancaBean {

	private Repositorios rep = new Repositorios();

	private String nomeUsuario;
	private String senha;

	public String logar() {

		try {
			this.getRequest().login(nomeUsuario, senha);
			return "Home?Faces-redirect=true";
		} catch (ServletException e) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, "Usuário ou senha invalido!");
			return null;
		}
	}

	public String sair() throws ServletException {
		this.getRequest().logout();
		return "Login?Faces-redirect=true";
	}

	private HttpServletRequest getRequest() {
		FacesContext context = FacesContext.getCurrentInstance();

		return (HttpServletRequest) context.getExternalContext().getRequest();
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

}
