package com.felipe.view;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.felipe.model.FechamentoOs;
import com.felipe.model.OrdemServico;
import com.felipe.repository.FechamentoOsRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class FechamentoOsBean {

	private OrdemServico os;

	private FechamentoOsRepository fechamentoDao;

	private FechamentoOs fechamento = new FechamentoOs(Calendar.getInstance().getTime());

	private Repositorios rep = new Repositorios();

	public void salvar() {

		try {
			this.os.setFechamento(this.fechamento);
			fechamentoDao = rep.getFechamentoOs();
			this.fechamento.setOs(this.os);

			fechamentoDao.salvar(this.fechamento);

			FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Fechamento realizado com sucesso.");
		} catch (Exception e) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, "Falha ao realizar fechamento");
		}

	}

	public OrdemServico getOs() {
		return os;
	}

	public void setOs(OrdemServico os) {
		this.os = os;
	}

	public FechamentoOs getFechamento() {
		return fechamento;
	}

	public void setFechamento(FechamentoOs fechamento) {
		this.fechamento = fechamento;
	}

}
