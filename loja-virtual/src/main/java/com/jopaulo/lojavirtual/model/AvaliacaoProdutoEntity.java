package com.jopaulo.lojavirtual.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_AVALIACAO_PRODUTO")
@SequenceGenerator(name = "SEQ_AVALIACAO_PRODUTO", sequenceName = "SEQ_AVALIACAO_PRODUTO", allocationSize = 1, initialValue = 1)
public class AvaliacaoProdutoEntity implements Serializable{
	
	
	private static final long serialVersionUID = 8262723174028703100L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AVALIACAO_PRODUTO")
	private Long id;
	
	@Column(nullable = false)
	private Integer nota;
	
	@Column(nullable = false)
	private String descricao;
	
	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne(targetEntity = PessoaEntity.class)
	@JoinColumn(
	    name = "pessoa_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "pessoa_fk"
	    )
	)
	private PessoaEntity pessoa;
	
	@ManyToOne
	@JoinColumn(
	    name = "produto_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "produto_fk"
	    )
	)
	private ProdutoEntity produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoProdutoEntity other = (AvaliacaoProdutoEntity) obj;
		return Objects.equals(id, other.id);
	}

}
