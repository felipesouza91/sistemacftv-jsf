package com.felipe.util;

import java.io.Serializable;

import com.felipe.repository.BairroRepository;
import com.felipe.repository.CidadeRepository;
import com.felipe.repository.ClienteRepository;
import com.felipe.repository.DvrRepository;
import com.felipe.repository.FechamentoOsRepository;
import com.felipe.repository.MontivoOsRepository;
import com.felipe.repository.OrdemServicoRepository;
import com.felipe.repository.StatusPortaRepository;
import com.felipe.repository.UsuarioRepository;
import com.felipe.repository.VerificacaoGravacaoRepository;
import com.felipe.repository.dao.BairroDAO;
import com.felipe.repository.dao.CidadeDAO;
import com.felipe.repository.dao.ClienteDAO;
import com.felipe.repository.dao.DvrDAO;
import com.felipe.repository.dao.FechamentoOsDAO;
import com.felipe.repository.dao.MotivoOsDAO;
import com.felipe.repository.dao.OrdemServicoDAO;
import com.felipe.repository.dao.StatusPortaDAO;
import com.felipe.repository.dao.UsuarioDAO;
import com.felipe.repository.dao.VerificacaoGravacaoDAO;

import org.hibernate.Session;

public class Repositorios implements Serializable {

	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}

	public BairroRepository getBairro() {
		return new BairroDAO(this.getSession());
	}

	public CidadeRepository getCidade() {
		return new CidadeDAO(this.getSession());
	}

	public ClienteRepository getCliente() {
		return new ClienteDAO(this.getSession());
	}

	public DvrRepository getDvr() {
		return new DvrDAO(this.getSession());
	}

	public OrdemServicoRepository getOs() {
		return new OrdemServicoDAO(this.getSession());
	}

	public UsuarioRepository getUsuario() {
		return new UsuarioDAO(this.getSession());
	}

	public StatusPortaRepository getStatusPortas() {
		return new StatusPortaDAO(this.getSession());
	}

	public MontivoOsRepository getMotivoOss() {
		return new MotivoOsDAO(this.getSession());
	}

	public FechamentoOsRepository getFechamentoOs() {
		return new FechamentoOsDAO(this.getSession());
	}

	public VerificacaoGravacaoRepository getVerificacaoGravacao() {
		return new VerificacaoGravacaoDAO(this.getSession());
	}
}
