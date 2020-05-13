package com.felipe.repository.dao;

import java.util.List;

import com.felipe.model.Usuario;
import com.felipe.repository.UsuarioRepository;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class UsuarioDAO implements UsuarioRepository {

	private Session session;

	public UsuarioDAO(Session session) {
		this.session = session;
	}

	@Override
	public Usuario getPorCodigo(Integer id) {

		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getTodos() {

		return session.createCriteria(Usuario.class).list();
	}

	@Override
	public void salvar(Usuario c) {
		session.merge(c);

	}

	@Override
	public void excluir(Usuario c) {

		session.delete(c);
	}

	@Override
	public List<Usuario> getPorFiltro(Integer tipoPesquisa, String descricaoFiltro) {

		switch (tipoPesquisa) {

			case 0: {
				return session.createCriteria(Usuario.class).list();

			}
			case 1: {
				return session.createCriteria(Usuario.class)
						.add(Restrictions.ilike("nomeUsuario", descricaoFiltro, MatchMode.ANYWHERE)).list();

			}
			case 2: {
				return session.createCriteria(Usuario.class)
						.add(Restrictions.ilike("nome", descricaoFiltro, MatchMode.ANYWHERE)).list();
			}
			case 3: {
				return session.createCriteria(Usuario.class)
						.add(Restrictions.ilike("prioridade", descricaoFiltro, MatchMode.ANYWHERE)).list();
			}

			default: {
				return null;
			}

		}
	}

	@Override
	public Usuario buscaLogin(String nome, String senha) {

		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("nomeUsuario", nome))
				.add(Restrictions.eq("senha", senha)).uniqueResult();
	}

}
