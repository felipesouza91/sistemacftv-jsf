package com.felipe.model;

public enum PrivilegioUsuario {

	USUARIO("USUARIO"), SUPERVISOR("SUPERVISOR"), ADMINISTRADOR("ADMINISTRADOR");

	private String descricao;

	PrivilegioUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
