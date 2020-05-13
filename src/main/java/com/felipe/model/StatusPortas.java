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

@Entity
public class StatusPortas implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	private boolean portaHttp;

	private boolean portaServico;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTeste;

	@ManyToOne
	@JoinColumn(name = "dvr", referencedColumnName = "id")
	private Dvr dvr;

	public StatusPortas() {

	}

	public StatusPortas(boolean http, boolean servico, Dvr dvr, Date data) {

		this.portaHttp = http;
		this.portaServico = servico;
		this.dvr = dvr;
		this.dataTeste = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isPortaHttp() {
		return portaHttp;
	}

	public void setPortaHttp(boolean portaHttp) {
		this.portaHttp = portaHttp;
	}

	public boolean isPortaServico() {
		return portaServico;
	}

	public void setPortaServico(boolean portaServico) {
		this.portaServico = portaServico;
	}

	public Dvr getDvr() {
		return dvr;
	}

	public void setDvr(Dvr dvr) {
		this.dvr = dvr;
	}

	public Date getDataTeste() {
		return dataTeste;
	}

	public void setDataTeste(Date dataTeste) {
		this.dataTeste = dataTeste;
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
		StatusPortas other = (StatusPortas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
