package com.felipe.model;

import javax.persistence.Entity;

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
