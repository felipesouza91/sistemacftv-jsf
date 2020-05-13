package com.felipe.repository;

import java.util.List;

import com.felipe.model.Bairro;
import com.felipe.model.Cidade;

public interface BairroRepository {

	public List<Bairro> getTodos();

	public Bairro getPorCodigo(Integer id);

	public List<Bairro> getPorFiltro(String filtro, String descricao);

	public List<Bairro> getPorCidade(Cidade cidade);

	public void salvar(Bairro bairro);
}
