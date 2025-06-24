package com.jopaulo.lojavirtual.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "MARCA_PRODUTO")
@SequenceGenerator(name = "SEQ_MARCA_PRODUTO", sequenceName = "SEQ_MARCA_PRODUTO", allocationSize = 1, initialValue = 1)
public class MarcaProdutoEntity implements Serializable {

	private static final long serialVersionUID = 8653795609475066596L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MARCA_PRODUTO")
	private Long id;
	private String nomeDescricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeDescricao() {
		return nomeDescricao;
	}
	public void setNomeDescricao(String nomeDescricao) {
		this.nomeDescricao = nomeDescricao;
	}
	

}
