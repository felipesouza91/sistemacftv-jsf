package com.felipe.view.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.felipe.model.Bairro;
import com.felipe.model.Cidade;
import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.repository.BairroRepository;
import com.felipe.repository.CidadeRepository;
import com.felipe.repository.ClienteRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroClienteBean implements Serializable {

	Repositorios repositorio = new Repositorios();
	private ClienteRepository clienteDao;
	private Cidade cidade;
	private Cliente cliente = new Cliente();
	private ArrayList<Bairro> listBairro = new ArrayList<Bairro>();
	private List<Dvr> listDvr = new ArrayList<Dvr>();
	private List<Cidade> listCidade = new ArrayList<Cidade>();

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		CidadeRepository cidadeDao = repositorio.getCidade();
		listCidade.addAll(cidadeDao.getTodos());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (cliente == null) {
			this.cliente = new Cliente();
			listBairro.clear();
		} else {
			this.cliente = cliente;
			this.listBairro.add(this.cliente.getBairro());
			cidade = this.cliente.getBairro().getCidade();
			this.listDvr.addAll(this.cliente.getListDvr());
		}

	}

	public List<Bairro> getListBairro() {
		return listBairro;
	}

	public void preencheBairro() {
		BairroRepository bairroDAO = repositorio.getBairro();
		listBairro = (ArrayList<Bairro>) bairroDAO.getPorCidade(cidade);
	}

	public void salvarCliente() {
		clienteDao = repositorio.getCliente();
		clienteDao.salvar(this.cliente);


		FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!");
	}

	public List<Dvr> getListDvr() {
		if (cliente == null) {
			return listDvr;
		} else {
			listDvr = (List<Dvr>) this.cliente.getListDvr();
			return listDvr;
		}
	}

	public List<Cidade> getListCidade() {
		return listCidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void novoCliente() {
		this.cliente = new Cliente();
	}

}
