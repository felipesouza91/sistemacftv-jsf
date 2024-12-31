package com.felipe.view.cadastros;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.model.VerificacaoGravacao;
import com.felipe.repository.DvrRepository;
import com.felipe.repository.VerificacaoGravacaoRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroVerificarGravacaoBean {

	private Repositorios rep = new Repositorios();

	private VerificacaoGravacaoRepository testeDao;

	private VerificacaoGravacao teste = new VerificacaoGravacao(Calendar.getInstance().getTime());

	private Cliente cliente;

	private ArrayList<Dvr> listDvr = new ArrayList<Dvr>();

	public void salvar() {
		try {
			teste.setUsuario(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
					.getUserPrincipal().getName());
			testeDao = rep.getVerificacaoGravacao();
			testeDao.salvar(teste);
			FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Testes salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao salvar teste");
		}

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setTeste(VerificacaoGravacao teste) {
		this.teste = teste;
	}

	public VerificacaoGravacao getTeste() {
		return teste;
	}

	public Repositorios getRep() {
		return rep;
	}

	public void setRep(Repositorios rep) {
		this.rep = rep;
	}

	public List<Dvr> getListDvr() {
		DvrRepository dvrdao = rep.getDvr();
		if (cliente != null) {
			listDvr.addAll(dvrdao.getTodosPorCliente(this.cliente));
		} else {
			return Collections.emptyList();
		}
		return listDvr;

	}

}