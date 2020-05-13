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

import org.hibernate.annotations.Cascade;

@Entity
public class Cliente implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	private Integer codigoService;

	@Column(nullable = false)
	private String razaoSocial;

	@Column(nullable = false)
	private String fantazia;

	@Column(nullable = false)
	private String telefone1;

	private String telefone2;

	@Column(nullable = false)
	private String dominio;

	@Column(nullable = false)
	private String rua;

	@Column(nullable = false)
	private Integer numero;

	private String complemento;

	private String referencia;

	@OneToOne
	@JoinColumn(name = "bairro", referencedColumnName = "id", nullable = false)

	private Bairro bairro;

	@OneToMany(mappedBy = "cliente", cascade = { javax.persistence.CascadeType.REMOVE })
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	// @LazyCollection(LazyCollectionOption.EXTRA)
	private Collection<Dvr> listDvr = new ArrayList<Dvr>();

	public Cliente(Integer codigoService, String razaoSocial, String fantazia, String telefone1, String telefone2,
			String dominio, String rua, Integer numero, String complemento, String referencia, Bairro bairro) {

		this.codigoService = codigoService;
		this.razaoSocial = razaoSocial;
		this.fantazia = fantazia;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.dominio = dominio;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.referencia = referencia;
		this.bairro = bairro;

	}

	public Cliente() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoService() {
		return codigoService;
	}

	public void setCodigoService(Integer codigoService) {
		this.codigoService = codigoService;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFantazia() {
		return fantazia;
	}

	public void setFantazia(String fantazia) {
		this.fantazia = fantazia;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Collection<Dvr> getListDvr() {
		return listDvr;
	}

	public void setListDvr(Collection<Dvr> listDvr) {
		this.listDvr = listDvr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getEnderecoFormatado() {
		return this.rua + " , " + this.numero + " - " + this.complemento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
