package com.felipe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class VerificacaoGravacao implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	private String status;

	private String hd;

	private int qtdGravacao;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTeste;

	@OneToOne
	@JoinColumn(name = "dvr", referencedColumnName = "id")
	private Dvr dvr;

	private String usuario;

	public VerificacaoGravacao(Dvr dvr) {
		this.dvr = dvr;

	}

	public VerificacaoGravacao() {

	}

	public VerificacaoGravacao(Date data) {
		this.dataTeste = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public int getQtdGravacao() {
		return qtdGravacao;
	}

	public void setQtdGravacao(int qtdGravacao) {
		this.qtdGravacao = qtdGravacao;
	}

	public Date getDataTeste() {
		return dataTeste;
	}

	public void setDataTeste(Date dataTeste) {
		this.dataTeste = dataTeste;
	}

	public Dvr getDvr() {
		return dvr;
	}

	public void setDvr(Dvr dvr) {
		this.dvr = dvr;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerificacaoGravacao other = (VerificacaoGravacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
