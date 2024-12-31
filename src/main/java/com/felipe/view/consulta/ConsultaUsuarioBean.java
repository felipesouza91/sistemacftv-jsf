package com.felipe.view.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.felipe.model.PrivilegioUsuario;
import com.felipe.model.Usuario;
import com.felipe.repository.UsuarioRepository;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class ConsultaUsuarioBean {

	private Repositorios rep = new Repositorios();
	private UsuarioRepository usuarioDao;
	private ArrayList<Usuario> listUsuario = new ArrayList<Usuario>();
	private Integer tipoPequisa;
	private String descricao;
	private boolean editar = false;
	private boolean render = false;

	public PrivilegioUsuario[] getPrivilegioUsuario() {
		return PrivilegioUsuario.values();
	}

	public void buscar() {
		usuarioDao = rep.getUsuario();

		listUsuario = (ArrayList<Usuario>) usuarioDao.getPorFiltro(tipoPequisa, descricao);

	}

	public void modificaPesquisaDescricao(ValueChangeEvent event) {
		Integer a = (Integer) event.getNewValue();

		if(a.equals(3)) {
			this.editar = false;
			this.render = true;
		} else {
			this.editar = true;
			this.render = false;
		}
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public Integer getTipoPequisa() {
		return tipoPequisa;
	}

	public void setTipoPequisa(Integer tipoPequisa) {
		this.tipoPequisa = tipoPequisa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isEditar() {
		return editar;
	}

	public boolean isRender() {
		return render;
	}

}
