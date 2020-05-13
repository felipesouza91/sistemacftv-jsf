package com.felipe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class FechamentoOs implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String motivoFechamento;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFechamento;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVisita;

	@Column(nullable = false)
	private String tecnico;

	@Type(type = "text")
	private String observcaoServico;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "os", referencedColumnName = "id", nullable = false, unique = true)
	private OrdemServico os;

	public FechamentoOs() {

	}

	public FechamentoOs(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMotivoFechamento() {
		return motivoFechamento;
	}

	public void setMotivoFechamento(String motivoFechamento) {
		this.motivoFechamento = motivoFechamento;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public OrdemServico getOs() {
		return os;
	}

	public void setOs(OrdemServico os) {
		this.os = os;
	}

	public String getObservcaoServico() {
		return observcaoServico;
	}

	public void setObservcaoServico(String observcaoServico) {
		this.observcaoServico = observcaoServico;
	}

}
