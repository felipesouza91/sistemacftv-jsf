package com.felipe.repository;

import java.util.List;

import com.felipe.model.Cidade;

public interface CidadeRepository {

	public List<Cidade> getTodos();

	public Cidade getPorCodigo(Integer id);

	public List<Cidade> getPorFiltro(String filtro, String descricao);

	public void salvar(Cidade cidade);
}
