package com.felipe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
public class Dvr implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private Integer portaHttp;

	@Column(nullable = false)
	private Integer portaServico;

	@Column(nullable = false)
	private String fabricante;

	@Column(nullable = false)
	private String modeloFabricante;

	@OneToOne
	@JoinColumn(name = "id")
	private Modelo modelo;

	@Column(nullable = false)
	private String ip;

	@Column(nullable = false)
	private String mascara;

	@Column(nullable = false)
	private String gateway;

	@Column(nullable = false)
	private String dnsPrincipal;

	private String dnsAlternativo;

	@Column(unique = true)
	private String numeroSerie;

	@Transient
	private boolean ultimoStatus;

	@OneToOne
	@JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
	private Cliente cliente;

	@OneToMany(mappedBy = "dvr", cascade = { javax.persistence.CascadeType.REMOVE })
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Collection<StatusPortas> listStatusPorta = new ArrayList<StatusPortas>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getDnsPrincipal() {
		return dnsPrincipal;
	}

	public void setDnsPrincipal(String dnsPrincipal) {
		this.dnsPrincipal = dnsPrincipal;
	}

	public String getDnsAlternativo() {
		return dnsAlternativo;
	}

	public void setDnsAlternativo(String dnsAlternativo) {
		this.dnsAlternativo = dnsAlternativo;
	}

	public Integer getPortaHttp() {
		return portaHttp;
	}

	public void setPortaHttp(Integer portaHttp) {
		this.portaHttp = portaHttp;
	}

	public Integer getPortaServico() {
		return portaServico;
	}

	public void setPortaServico(Integer portaServico) {
		this.portaServico = portaServico;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModeloFabricante() {
		return modeloFabricante;
	}

	public void setModeloFabricante(String modeloFabricante) {
		this.modeloFabricante = modeloFabricante;
	}

	public boolean isUltimoStatus() {
		return ultimoStatus;
	}

	public void setUltimoStatus(boolean ultimoStatus) {
		this.ultimoStatus = ultimoStatus;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie.toUpperCase();
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
		Dvr other = (Dvr) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
