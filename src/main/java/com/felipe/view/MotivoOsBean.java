package com.felipe.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.felipe.model.MotivoOs;
import com.felipe.repository.MontivoOsRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class MotivoOsBean {

	private Repositorios rep = new Repositorios();
	private MotivoOs motivoOs = new MotivoOs();
	private MotivoOs motivoSelecionado = new MotivoOs();
	private List<MotivoOs> listMotivoOs;
	private MontivoOsRepository motivoOsDao;

	@PostConstruct
	public void inicio() {
		motivoOsDao = rep.getMotivoOss();
		listMotivoOs = motivoOsDao.getTodos();
	}

	public MotivoOs getMotivoOs() {
		return motivoOs;
	}

	public void setMotivoOs(MotivoOs motivoOs) {
		this.motivoOs = motivoOs;
	}

	public MotivoOs getMotivoSelecionado() {
		return motivoSelecionado;
	}

	public void setMotivoSelecionado(MotivoOs motivoSelecionado) {
		this.motivoSelecionado = motivoSelecionado;
	}

	public List<MotivoOs> getListMotivoOs() {
		return listMotivoOs;
	}

	public void salvar() {
		motivoOsDao = rep.getMotivoOss();

		motivoOsDao.salvar(motivoOs);

		this.motivoOs = new MotivoOs();

		FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Motivo Cadastrado com Sucesso!");
		this.inicio();
	}

	public void excluir() {
		motivoOsDao = rep.getMotivoOss();
		String msg;
		Severity severity;
		try {
			motivoOsDao.excluir(this.motivoSelecionado);
			msg = "Motivo de Ordem de Serviço excluido com sucesso";
			severity = FacesMessage.SEVERITY_INFO;
		} catch (Exception e) {
			msg = "Erro ao Excluir: \n" + e.getMessage();
			severity = FacesMessage.SEVERITY_ERROR;
		}

		FacesUtil.addMensagem(severity, msg);
		this.inicio();
	}
}
