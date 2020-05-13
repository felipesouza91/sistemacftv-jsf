package com.felipe.view.cadastros;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.model.TipoFabricante;
import com.felipe.repository.DvrRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroDvrBean {

	private Repositorios rep = new Repositorios();

	private Cliente cliente;
	private Dvr dvr = new Dvr();
	private List<Dvr> listDvr;
	private boolean editSerial = false;
	private DvrRepository dvrDao;
	private String opcao;

	public void salvar() {
		dvrDao = rep.getDvr();

		dvr.setCliente(this.cliente);

		dvrDao.salvar(dvr);

		FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Cadastro realizado com Sucesso!");
	}

	public void editaSerial() {
		if (this.getOpcao().equals("INTELBRAS")) {
			editSerial = true;
		} else {
			editSerial = false;
		}
	}

	public void mudaFabricante(ValueChangeEvent evt) {
		this.opcao = (String) evt.getNewValue();
		this.editaSerial();
		FacesContext.getCurrentInstance().renderResponse();

	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public TipoFabricante[] getTiposFabricante() {
		return TipoFabricante.values();
	}

	public Dvr getDvr() {
		return dvr;
	}

	public void setDvr(Dvr dvr) {
		this.dvr = dvr;
	}

	public List<Dvr> getListDvr() {
		return listDvr;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isEditSerial() {
		return editSerial;
	}

	public void setEditSerial(boolean editSerial) {
		this.editSerial = editSerial;
	}

}
