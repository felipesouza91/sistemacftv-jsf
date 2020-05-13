package com.felipe.repository.dao;

import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.model.StatusPortas;
import com.felipe.repository.DvrRepository;
import com.felipe.repository.StatusPortaRepository;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DvrDAO implements DvrRepository {

	private Session session;

	public DvrDAO(Session s) {
		this.session = s;
	}

	@Override
	public Dvr getPorCodigo(Integer id) {

		return (Dvr) session.get(Dvr.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dvr> getTodos() {

		return session.createCriteria(Dvr.class).list();
	}

	@Override
	public void salvar(Dvr c) {

		session.merge(c);
	}

	@Override
	public void excluir(Dvr c) {

	}

	@Override
	public List<Dvr> getTodosPorCliente(Cliente c) {

		return session.createCriteria(Dvr.class).createAlias("cliente", "cl").add(Restrictions.eq("cl.id", c.getId()))
				.list();
	}

	@Override
	public List<Dvr> getTodosUltimaAtualizacao() {
		List<Dvr> listDvr = this.getTodos();
		StatusPortaRepository statusPortasDao = new StatusPortaDAO(this.session);
		for (Dvr dvr : listDvr) {

			StatusPortas status = statusPortasDao.getUltimoStatus(dvr);
			try {
				dvr.setUltimoStatus(status.isPortaHttp() && status.isPortaServico());
			} catch (Exception e) {
				dvr.setUltimoStatus(false);
			}

		}

		return listDvr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dvr> getporSerial(String serial) {

		return session.createCriteria(Dvr.class).add(Restrictions.like("numeroSerie", serial)).list();
	}

}
