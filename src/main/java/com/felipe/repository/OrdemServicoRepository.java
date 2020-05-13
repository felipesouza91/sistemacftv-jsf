package com.felipe.repository;

import java.util.Date;
import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.MotivoOs;
import com.felipe.model.OrdemServico;

public interface OrdemServicoRepository {

	public OrdemServico getPorCodigo(Integer id);

	public List<OrdemServico> getPorCodigoService(Integer codigoService);

	public List<OrdemServico> getTodos();

	public void salvar(OrdemServico c);

	public void excluir(OrdemServico c);

	public List<OrdemServico> getPorFiltro(int codigoFiltro, String descricao);

	public List<OrdemServico> getTodosPorCliente(Cliente c);

	public List<OrdemServico> getPorFiltroData(int tipoPequisa, Date dataPesquisa);

	public List<OrdemServico> getPorMotivoOs(MotivoOs motivoOs);

	public List<OrdemServico> getSemService();

	public List<OrdemServico> getSemFechamento();

	public List<OrdemServico> getComPendencias();
}
