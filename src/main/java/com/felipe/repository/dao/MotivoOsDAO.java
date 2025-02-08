package com.felipe.repository.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.felipe.model.MotivoOs;
import com.felipe.repository.MontivoOsRepository;

public class MotivoOsDAO implements MontivoOsRepository {

	private Session session;

	public MotivoOsDAO(Session session) {
		this.session = session;
	}

	@Override
	public MotivoOs getPorCodigo(Integer id) {

		return (MotivoOs) session.createCriteria(MotivoOs.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MotivoOs> getTodos() {

		return session.createCriteria(MotivoOs.class).addOrder(Order.asc("descricao")).list();
	}

	@Override
	public void salvar(MotivoOs c) {

		session.merge(c);
	}

	@Override
	public void excluir(MotivoOs c) {
		MotivoOs motivoos = getPorCodigo(c.getId());
		session.delete(motivoos);
	}

}
