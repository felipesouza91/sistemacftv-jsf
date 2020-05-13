package com.felipe.view.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.repository.DvrRepository;
import com.felipe.repository.StatusPortaRepository;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class ConsultaDvrBean {

	private Repositorios rep = new Repositorios();
	private Cliente cliente;
	private List<Dvr> listDvr = new ArrayList<Dvr>();
	private DvrRepository dvrDao = rep.getDvr();
	private StatusPortaRepository statusPortasDao;

	@PostConstruct
	public void init() {
		listDvr = dvrDao.getTodosUltimaAtualizacao();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Dvr> getListDvr() {
		return listDvr;
	}

}
