package com.felipe.repository.dao;

import java.util.List;

import com.felipe.model.Cidade;
import com.felipe.repository.CidadeRepository;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CidadeDAO implements CidadeRepository {

	private Session session;

	public CidadeDAO(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Cidade cidade) {
		this.session.merge(cidade);

	}

	@Override
	public List<Cidade> getTodos() {

		return session.createCriteria(Cidade.class).list();
	}

	@Override
	public Cidade getPorCodigo(Integer id) {

		return (Cidade) session.createCriteria(Cidade.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Cidade> getPorFiltro(String filtro, String descricao) {

		return null;
	}

}
