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
@Table(name = "TB_NOTA_ITEM_PRODUTO")
@SequenceGenerator(name = "SEQ_NOTA_ITEM_PRODUTO", sequenceName = "SEQ_NOTA_ITEM_PRODUTO", allocationSize = 1, initialValue = 1)
public class NotaItemProdutoEntity implements Serializable{
	
	private static final long serialVersionUID = 8842893520061034826L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTA_ITEM_PRODUTO")
	private Long id;
	
	@Column(nullable = false)
	private Double quantidade;
	
	@ManyToOne
	@JoinColumn(
	    name = "nota_fiscal_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "nota_fiscal_fk"
	    )
	)
	private NotaFiscalCompraEntity notaFiscalCompraEntity;
	
	@ManyToOne
	@JoinColumn(
	    name = "produto_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "produto_fk"
	    )
	)
	private ProdutoEntity produtoEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutoEntity getProdutoEntity() {
		return produtoEntity;
	}

	public void setProdutoEntity(ProdutoEntity produtoEntity) {
		this.produtoEntity = produtoEntity;
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
		NotaItemProdutoEntity other = (NotaItemProdutoEntity) obj;
		return Objects.equals(id, other.id);
	}

	public NotaFiscalCompraEntity getNotaFiscalCompraEntity() {
		return notaFiscalCompraEntity;
	}

	public void setNotaFiscalCompraEntity(NotaFiscalCompraEntity notaFiscalCompraEntity) {
		this.notaFiscalCompraEntity = notaFiscalCompraEntity;
	}

}
