package com.jopaulo.lojavirtual.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PESSOA_JURIDICA")
public class PessoaJuridicaEntity extends PessoaEntity {

	private static final long serialVersionUID = -1611706296657066939L;
	
	@Column(nullable = false)
	private String cnpj;
	private String inscMunicipal;
	private String inscEstadual;
	@Column(nullable = false)
	private String nomeFantasia;
	@Column(nullable = false)
	private String razaoSocial;
	private String categoria;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscMunicipal() {
		return inscMunicipal;
	}
	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}
	public String getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
