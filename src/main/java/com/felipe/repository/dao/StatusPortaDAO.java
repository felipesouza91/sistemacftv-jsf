package com.felipe.repository.dao;

import java.util.Date;
import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.model.StatusPortas;
import com.felipe.repository.StatusPortaRepository;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class StatusPortaDAO implements StatusPortaRepository {

	private Session session;

	public StatusPortaDAO(Session session) {
		this.session = session;
	}

	@Override
	public StatusPortas getPorCodigo(Integer id) {

		return (StatusPortas) session.createCriteria(StatusPortas.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<StatusPortas> getTodos() {

		return session.createCriteria(StatusPortas.class).list();
	}

	@Override
	public void salvar(StatusPortas c) {

		session.merge(c);

	}

	@Override
	public void excluir(StatusPortas c) {

		session.delete(c);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusPortas> getTodosPorCliente(Cliente c) {

		return session.createCriteria(StatusPortas.class).createAlias("dvr", "d")
				.add(Restrictions.eq("d.cliente.id", c.getId())).addOrder(Order.asc("dataTeste")).list();
	}

	@Override
	public List<StatusPortas> getPorFiltroData(int tipoPequisa, Date dataPesquisa) {

		return null;
	}

	@Override
	public StatusPortas getUltimoStatus(Dvr c) {

		return (StatusPortas) session.createCriteria(StatusPortas.class).createAlias("dvr", "d")
				.add(Restrictions.eq("d.id", c.getId())).addOrder(Order.asc("dataTeste")).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusPortas> getTodosDvr(Dvr dvr) {

		return session.createCriteria(StatusPortas.class).createAlias("dvr", "d").add(Restrictions.eq("d.id", dvr.getId()))
				.list();

	}

}
