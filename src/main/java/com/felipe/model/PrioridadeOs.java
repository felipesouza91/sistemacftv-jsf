package com.felipe.model;

public enum PrioridadeOs {

	NORMAL("Normal"), URGENTE("Urgente"), PRIORIDADE("Prioridade");

	private String descricao;

	PrioridadeOs(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
