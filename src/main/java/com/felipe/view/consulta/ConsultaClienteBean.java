package com.felipe.view.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.felipe.model.Cliente;
import com.felipe.repository.ClienteRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class ConsultaClienteBean {

	private Repositorios rep = new Repositorios();
	private List<Cliente> listCliente = new ArrayList<Cliente>();
	private ClienteRepository clienteDAO;
	private Integer tipoPesquisa;
	private Cliente clienteExcluir = new Cliente();
	private String descricaoPesquisa = null;
	private boolean edita = false;

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	@SuppressWarnings("unchecked")
	public void pesquisar() {
		listCliente.clear();
		clienteDAO = rep.getCliente();

		listCliente = clienteDAO.getPorFiltro(tipoPesquisa, descricaoPesquisa);

		if (listCliente.isEmpty()) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, "Não foi encontrado Clientes com as informações descritas");
		}
	}

	public void excluir() {

		clienteDAO = rep.getCliente();
		try {
			clienteDAO.excluir(clienteExcluir);
			FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Cliente excluido com sucesso");
			listCliente = clienteDAO.getPorFiltro(tipoPesquisa, descricaoPesquisa);
		} catch (Exception e) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao excluir cliente");
		}

	}

	public Cliente getClienteExcluir() {
		return clienteExcluir;
	}

	public void setClienteExcluir(Cliente clienteExcluir) {
		this.clienteExcluir = clienteExcluir;
	}

	public Integer getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(Integer tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

	public void setDescricaoPesquisa(String descricaoPesquisa) {
		this.descricaoPesquisa = descricaoPesquisa;
	}

	public String getDescricaoPesquisa() {
		return descricaoPesquisa;
	}

	public void modificaCampo(ValueChangeEvent evt) {
		Integer a = (Integer) evt.getNewValue();

		if (a != 0) {
			this.edita = true;

		} else {
			if (a == 0) {
				this.edita = false;
			}
		}
		this.descricaoPesquisa = null;
	}

	public boolean isEdita() {
		return edita;
	}

	public void modificaDescricao(ValueChangeEvent evt) {
		this.descricaoPesquisa = (String) evt.getNewValue();
	}

}
