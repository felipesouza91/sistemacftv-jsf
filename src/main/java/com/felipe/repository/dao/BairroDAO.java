package com.felipe.repository.dao;

import java.util.List;

import com.felipe.model.Bairro;
import com.felipe.model.Cidade;
import com.felipe.repository.BairroRepository;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class BairroDAO implements BairroRepository {

	Session session;

	public BairroDAO(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Bairro bairro) {

		this.session.merge(bairro);

	}

	@Override
	public List<Bairro> getTodos() {

		return session.createCriteria(Bairro.class).list();
	}

	@Override
	public Bairro getPorCodigo(Integer id) {

		return session.get(Bairro.class, id);
	}

	@Override
	public List<Bairro> getPorFiltro(String filtro, String descricao) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bairro> getPorCidade(Cidade cidade) {

		return session.createCriteria(Bairro.class).createAlias("cidade", "c").add(Restrictions.eq("c.id", cidade.getId()))
				.addOrder(Order.asc("nome")).list();
	}

}
