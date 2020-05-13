package com.felipe.repository.dao;

import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.repository.ClienteRepository;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ClienteDAO implements ClienteRepository {

	private Session session;

	public ClienteDAO(Session s) {
		this.session = s;
	}

	@Override
	public Cliente getPorCodigo(Integer id) {

		return (Cliente) session.createCriteria(Cliente.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Cliente> getPorCodigoService(Integer codigoService) {
		return session.createCriteria(Cliente.class).add(Restrictions.eq("codigoService", codigoService)).list();
	}

	@Override
	public List<Cliente> getTodos() {

		return session.createCriteria(Cliente.class).addOrder(Order.asc("id")).list();

	}

	@Override
	public void salvar(Cliente c) {
		session.merge(c);
	}

	@Override
	public void excluir(Cliente c) {
		session.delete(c);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getPorFiltro(int codigoFiltro, String descricao) {

		switch (codigoFiltro) {

			case 1: {
				return session.createCriteria(Cliente.class).add(Restrictions.ilike("dominio", descricao, MatchMode.ANYWHERE))
						.list();

			}
			case 2: {
				return session.createCriteria(Cliente.class)
						.add(Restrictions.ilike("razaoSocial", descricao, MatchMode.ANYWHERE)).list();
			}
			case 3: {
				return session.createCriteria(Cliente.class).add(Restrictions.ilike("fantazia", descricao, MatchMode.ANYWHERE))
						.list();
			}
			case 4: {
				return session.createCriteria(Cliente.class).createAlias("bairro", "b")
						.add(Restrictions.like("b.nome", descricao, MatchMode.ANYWHERE)).list();
			}
			case 5: {
				return session.createCriteria(Cliente.class).add(Restrictions.ilike("rua", descricao, MatchMode.ANYWHERE))
						.list();
			}
			case 6: {
				return this.getPorCodigoService(Integer.parseInt(descricao));
			}

			default:
				return this.getTodos();
		}

	}

}
