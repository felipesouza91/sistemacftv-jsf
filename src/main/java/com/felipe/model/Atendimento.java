package com.felipe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class Atendimento implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Type(type = "text")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cliene", referencedColumnName = "id", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "dvr", referencedColumnName = "id")
	private Dvr dvr;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtendimento;

	public Atendimento() {

	}

	public Atendimento(Date data) {
		this.dataAtendimento = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Dvr getDvr() {
		return dvr;
	}

	public void setDvr(Dvr dvr) {
		this.dvr = dvr;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
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
		Atendimento other = (Atendimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
