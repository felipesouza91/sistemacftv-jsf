package com.felipe.repository;

import java.util.List;

import com.felipe.model.Cliente;

public interface ClienteRepository {

	public Cliente getPorCodigo(Integer id);

	public List<Cliente> getPorCodigoService(Integer codigoService);

	public List<Cliente> getTodos();

	public void salvar(Cliente c);

	public void excluir(Cliente c);

	public List<Cliente> getPorFiltro(int codigoFiltro, String descricao);

}
