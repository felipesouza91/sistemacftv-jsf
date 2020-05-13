package com.felipe.view.cadastros;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.felipe.model.Cliente;
import com.felipe.model.MotivoOs;
import com.felipe.model.OrdemServico;
import com.felipe.model.PrioridadeOs;
import com.felipe.repository.OrdemServicoRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroOrdemServicoBean {

	private Repositorios rep = new Repositorios();

	private OrdemServicoRepository osDao;

	private Cliente cliente;

	private List<MotivoOs> listMotivo;

	private OrdemServico ordemServico = new OrdemServico(Calendar.getInstance().getTime());

	public PrioridadeOs[] getPrioridadeOs() {

		return PrioridadeOs.values();

	}

	@PostConstruct
	public void inicio() {
		listMotivo = rep.getMotivoOss().getTodos();
	}

	public List<MotivoOs> getListMotivo() {
		return listMotivo;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
		// this.ordemServico.setCliente(this.cliente);
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void salvar() {
		osDao = rep.getOs();
		this.ordemServico.setCliente(this.cliente);
		osDao.salvar(this.ordemServico);

		this.ordemServico = new OrdemServico(Calendar.getInstance().getTime());

		FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Ordem Cadastrada com sucesso!");
	}

}
