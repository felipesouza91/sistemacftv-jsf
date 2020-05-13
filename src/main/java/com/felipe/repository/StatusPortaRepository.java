package com.felipe.repository;

import java.util.Date;
import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.model.StatusPortas;

public interface StatusPortaRepository {

	public StatusPortas getPorCodigo(Integer id);

	public List<StatusPortas> getTodos();

	public void salvar(StatusPortas c);

	public void excluir(StatusPortas c);

	public List<StatusPortas> getTodosPorCliente(Cliente c);

	public List<StatusPortas> getPorFiltroData(int tipoPequisa, Date dataPesquisa);

	public StatusPortas getUltimoStatus(Dvr c);

	public List<StatusPortas> getTodosDvr(Dvr dvr);
}
