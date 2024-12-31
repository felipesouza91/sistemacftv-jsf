package com.felipe.view.consulta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.felipe.model.Dvr;
import com.felipe.model.VerificacaoGravacao;
import com.felipe.repository.DvrRepository;
import com.felipe.repository.VerificacaoGravacaoRepository;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class ConsultaTesteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Repositorios rep = new Repositorios();

	private transient VerificacaoGravacaoRepository testeDao = rep.getVerificacaoGravacao();

	private transient DvrRepository dvrDao = rep.getDvr();

	private ArrayList<Dvr> listDvr = new ArrayList<Dvr>();

	private ArrayList<VerificacaoGravacao> listTeste = new ArrayList<VerificacaoGravacao>();

	@PostConstruct
	public void init() {
		listDvr.addAll(dvrDao.getTodos());

		for (Dvr dvr : listDvr) {
			VerificacaoGravacao testando = testeDao.getUltimoTeste(dvr);
			if (testando == null) {
				listTeste.add(new VerificacaoGravacao(dvr));
			} else {
				listTeste.add(testando);
			}

		}
	}

	public List<VerificacaoGravacao> getListTeste() {
		return listTeste;
	}

}
