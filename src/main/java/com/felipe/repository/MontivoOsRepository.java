package com.felipe.repository;

import java.util.List;

import com.felipe.model.MotivoOs;

public interface MontivoOsRepository {

	public MotivoOs getPorCodigo(Integer id);

	public List<MotivoOs> getTodos();

	public void salvar(MotivoOs c);

	public void excluir(MotivoOs c);

}
