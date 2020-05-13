package com.felipe.repository.dao;

import java.util.Collection;
import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.FechamentoOs;
import com.felipe.model.OrdemServico;
import com.felipe.repository.FechamentoOsRepository;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class FechamentoOsDAO implements FechamentoOsRepository {

	private Session session;

	public FechamentoOsDAO(Session session) {
		this.session = session;
	}

	@Override
	public FechamentoOs getPorCodigo(Integer id) {

		return (FechamentoOs) session.createCriteria(FechamentoOs.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FechamentoOs> getTodos() {

		return session.createCriteria(FechamentoOs.class).list();
	}

	@Override
	public void salvar(FechamentoOs fechamento) {

		session.merge(fechamento);
	}

	@Override
	public void excluir(FechamentoOs fechamento) {

		session.delete(fechamento);
	}

	@Override
	public FechamentoOs getPorOrdemDeServico(OrdemServico os) {

		return (FechamentoOs) session.createCriteria(FechamentoOs.class).createAlias("OrdemServico", "os")
				.add(Restrictions.eq("os.id", os.getId())).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<FechamentoOs> getPorCliente(Cliente cliente) {

		return session.createCriteria(FechamentoOs.class).createAlias("OrdemServico", "os")
				.add(Restrictions.eq("os.cliente.id", cliente.getId())).list();
	}

}
