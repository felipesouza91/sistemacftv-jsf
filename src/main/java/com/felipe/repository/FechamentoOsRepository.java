package com.felipe.repository;

import java.util.Collection;
import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.FechamentoOs;
import com.felipe.model.OrdemServico;

public interface FechamentoOsRepository {

	public FechamentoOs getPorCodigo(Integer id);

	public List<FechamentoOs> getTodos();

	public void salvar(FechamentoOs fechamento);

	public void excluir(FechamentoOs fechamento);

	public FechamentoOs getPorOrdemDeServico(OrdemServico os);

	public Collection<FechamentoOs> getPorCliente(Cliente cliente);

}
