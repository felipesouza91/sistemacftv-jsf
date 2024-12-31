package com.felipe.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class OrdemServico implements Serializable {

	public static final String CODIGO_SERVICE_COLUMN = "codigoService";

	@Id
	@GeneratedValue
	private Integer id;

	private Integer codigoService;

	@OneToOne
	@JoinColumn(name = "motivoOs", referencedColumnName = "id", nullable = false)
	private MotivoOs motivoOs;

	@Type(type = "text")
	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false, length = 11)
	private String prioridadeOs;

	private String solicitante;

	@OneToOne
	@JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name = "dvr", referencedColumnName = "id")
	private Dvr dvr;

	@OneToMany
	private Collection<Contato> contatos;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "fechamento", referencedColumnName = "id")
	private FechamentoOs fechamento;

	public OrdemServico() {

	}

	public OrdemServico(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MotivoOs getMotivoOs() {
		return motivoOs;
	}

	public void setMotivoOs(MotivoOs motivoOs) {
		this.motivoOs = motivoOs;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
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

	public Integer getCodigoService() {
		return codigoService;
	}

	public void setCodigoService(Integer codigoService) {
		this.codigoService = codigoService;
	}

	public Collection<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Collection<Contato> contatos) {
		this.contatos = contatos;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getPrioridadeOs() {
		return prioridadeOs;
	}

	public void setPrioridadeOs(String prioridadeOS) {
		this.prioridadeOs = prioridadeOS;
	}

	public FechamentoOs getFechamento() {
		return fechamento;
	}

	public void setFechamento(FechamentoOs fechamento) {
		this.fechamento = fechamento;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
