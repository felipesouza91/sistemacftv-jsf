package com.felipe.repository;

import java.util.List;

import com.felipe.model.Usuario;

public interface UsuarioRepository {

	public Usuario getPorCodigo(Integer id);

	public List<Usuario> getTodos();

	public void salvar(Usuario c);

	public void excluir(Usuario c);

	public List<Usuario> getPorFiltro(Integer tipoPesquisa, String descricaoFiltro);

	public Usuario buscaLogin(String nome, String senha);
}
