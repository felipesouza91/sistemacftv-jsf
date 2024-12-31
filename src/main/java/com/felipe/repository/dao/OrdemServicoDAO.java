package com.felipe.repository.dao;

import java.util.Date;
import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.MotivoOs;
import com.felipe.model.OrdemServico;
import com.felipe.repository.OrdemServicoRepository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class OrdemServicoDAO implements OrdemServicoRepository {

	private Session session;

	private static final String CLIENTE_TABLE_NAME = "cliente";


	public OrdemServicoDAO(Session session) {
		this.session = session;
	}

	@Override
	public OrdemServico getPorCodigo(Integer id) {

		return (OrdemServico) session.createCriteria(OrdemServico.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<OrdemServico> getPorCodigoService(Integer codigoService) {

		return session.createCriteria(OrdemServico.class).add(Restrictions.eq(OrdemServico.CODIGO_SERVICE_COLUMN, codigoService)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> getTodos() {

		return session.createCriteria(OrdemServico.class).list();
	}

	@Override
	public void salvar(OrdemServico c) {

		session.merge(c);

	}

	@Override
	public void excluir(OrdemServico c) {

		session.delete(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> getPorFiltro(int codigoFiltro, String descricao) {

		switch (codigoFiltro) {

			case 0: {
				return session.createCriteria(OrdemServico.class).list();

			}
			case 1: {
				return session.createCriteria(OrdemServico.class).createAlias(CLIENTE_TABLE_NAME, "c")
						.add(Restrictions.ilike("c.razaoSocial", descricao, MatchMode.ANYWHERE)).list();
			}
			case 2: {
				return session.createCriteria(OrdemServico.class).createAlias(CLIENTE_TABLE_NAME, "c")
						.add(Restrictions.ilike("c.fantazia", descricao, MatchMode.ANYWHERE)).list();
			}
			case 3: {
				return session.createCriteria(OrdemServico.class).createAlias(CLIENTE_TABLE_NAME, "c")
						.add(Restrictions.ilike("c.bairro.nome", descricao, MatchMode.ANYWHERE)).list();
			}
			case 4: {
				return session.createCriteria(OrdemServico.class).createAlias(CLIENTE_TABLE_NAME, "c")
						.add(Restrictions.ilike("c.rua", descricao, MatchMode.ANYWHERE)).list();
			}
			case 6: {
				return session.createCriteria(OrdemServico.class).add(Restrictions.eq("prioridadeOs", descricao)).list();

			}
			case 8: {
				return this.getPorCodigoService(Integer.parseInt(descricao));
			}

			default: {
				return null;
			}

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> getTodosPorCliente(Cliente c) {

		return session.createCriteria(OrdemServico.class).createAlias("cliente", "c")
				.add(Restrictions.eq("c.id", c.getId())).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> getPorFiltroData(int tipoPequisa, Date dataPesquisa) {
		Date dataPesquisafinal = new Date();
		dataPesquisafinal.setTime(dataPesquisa.getTime());
		dataPesquisafinal.setHours(23);
		dataPesquisafinal.setMinutes(59);
		dataPesquisafinal.setSeconds(59);
		return session.createCriteria(OrdemServico.class).add(Restrictions.gt("dataAbertura", dataPesquisa))
				.add(Restrictions.lt("dataAbertura", dataPesquisafinal)).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> getPorMotivoOs(MotivoOs motivoOs) {

		return session.createCriteria(OrdemServico.class).createAlias("motivoOs", "mOs")
				.add(Restrictions.eq("mOs.id", motivoOs.getId())).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> getSemService() {

		return session.createCriteria(OrdemServico.class).add(Restrictions.isNull(OrdemServico.CODIGO_SERVICE_COLUMN)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> getSemFechamento() {

		return session.createCriteria(OrdemServico.class).add(Restrictions.isNull("fechamento")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemServico> getComPendencias() {

		Criteria c = session.createCriteria(OrdemServico.class);
		Criterion fechamento = Restrictions.isNull("fechamento");
		Criterion prioridade = Restrictions.eq("prioridadeOs", "PRIORIDADE");
		Criterion service = Restrictions.isNull(OrdemServico.CODIGO_SERVICE_COLUMN);

		LogicalExpression or = Restrictions.or(service, prioridade);
		LogicalExpression or2 = Restrictions.and(or, fechamento);
		c.add(or2);

		return c.list();

	
	}

}
