package com.felipe.repository.dao;

import java.util.ArrayList;
import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.model.VerificacaoGravacao;
import com.felipe.repository.VerificacaoGravacaoRepository;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class VerificacaoGravacaoDAO implements VerificacaoGravacaoRepository {

	private Session session;

	public VerificacaoGravacaoDAO(Session session) {
		this.session = session;
	}

	@Override
	public VerificacaoGravacao getPorCodigo(Integer id) {

		return (VerificacaoGravacao) session.createCriteria(VerificacaoGravacao.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VerificacaoGravacao> getPorDvr(Dvr dvr) {

		return session.createCriteria(VerificacaoGravacao.class).createAlias("dvr", "d")
				.add(Restrictions.eq("d.id", dvr.getId())).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VerificacaoGravacao> getPorCliente(Cliente cliente) {

		return session.createCriteria(VerificacaoGravacao.class).createAlias("dvr", "d")
				.add(Restrictions.eq("d.cliente.id", cliente.getId())).list();
	}

	@Override
	public List<VerificacaoGravacao> getTodos() {

		return session.createCriteria(VerificacaoGravacao.class).list();
	}

	@Override
	public void salvar(VerificacaoGravacao obj) {
		this.session.merge(obj);
	}

	@Override
	public VerificacaoGravacao getUltimoTeste(Dvr obj) {
		return (VerificacaoGravacao) session.createCriteria(VerificacaoGravacao.class).createAlias("dvr", "d")
				.add(Restrictions.eq("d.id", obj.getId())).addOrder(Order.desc("dataTeste")).setMaxResults(1).uniqueResult();

	}

	@Override
	public List<VerificacaoGravacao> getPorFiltro(int codigoFiltro, String filtro) {
		List<VerificacaoGravacao> listResultado = new ArrayList<>();

		switch (codigoFiltro) {
			// Retorna filtro equipamento
			case 1: {
				return session.createCriteria(VerificacaoGravacao.class).createAlias("dvr", "d")
						.add(Restrictions.eq("d.modeloFabricante", filtro.toUpperCase())).addOrder(Order.desc("dataTeste")).list();

			}
			case 2: {
				break;
			}
			case 3: {
				break;
			}

			default:
				break;
		}

		return listResultado;
	}

}
