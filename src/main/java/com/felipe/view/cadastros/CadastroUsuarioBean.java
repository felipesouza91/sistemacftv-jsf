package com.felipe.view.cadastros;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.felipe.model.PrivilegioUsuario;
import com.felipe.model.Usuario;
import com.felipe.repository.UsuarioRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroUsuarioBean {

	Repositorios rep = new Repositorios();
	UsuarioRepository usuarioDao;
	Usuario usuario = new Usuario();

	public PrivilegioUsuario[] getPrivilegioUsuario() {
		return PrivilegioUsuario.values();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void salvar() {
		usuarioDao = rep.getUsuario();

		usuarioDao.salvar(this.usuario);

		FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com suscesso");
	}

	public void novoUsuario() {
		this.usuario = new Usuario();
	}

}
