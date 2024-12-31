package com.felipe.repository;

import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;

public interface DvrRepository {

	public Dvr getPorCodigo(Integer id);

	public List<Dvr> getTodos();

	public void salvar(Dvr c);

	public void excluir(Dvr c);

	public List<Dvr> getTodosPorCliente(Cliente c);

	public List<Dvr> getTodosUltimaAtualizacao();

	public List<Dvr> getporSerial(String serial);
}
