package com.felipe.repository;

import java.util.List;

import com.felipe.model.Cliente;
import com.felipe.model.Dvr;
import com.felipe.model.VerificacaoGravacao;

public interface VerificacaoGravacaoRepository {

	public VerificacaoGravacao getPorCodigo(Integer id);

	public List<VerificacaoGravacao> getPorDvr(Dvr dvr);

	public List<VerificacaoGravacao> getPorCliente(Cliente cliente);

	public List<VerificacaoGravacao> getPorFiltro(int codigoFiltro, String filtro);

	public List<VerificacaoGravacao> getTodos();

	public VerificacaoGravacao getUltimoTeste(Dvr obj);

	public void salvar(VerificacaoGravacao obj);

}
