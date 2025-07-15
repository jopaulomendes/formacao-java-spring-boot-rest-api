package com.jopaulo.lojavirtual.model;

import java.io.Serializable;
import java.util.Objects;

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
@Table(name = "TB_ITEM_VENDA_LOJA")
@SequenceGenerator(name = "SEQ_ITEM_VENDA_LOJA", sequenceName = "SEQ_ITEM_VENDA_LOJA", allocationSize = 1, initialValue = 1)
public class IntemVendaLojaEntity implements Serializable{
	
	private static final long serialVersionUID = -4838745993368392837L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM_VENDA_LOJA")
	private Long id;
	
	private Double quantidade;
	
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
	
	@ManyToOne
	@JoinColumn(
	    name = "venda_loja_virtual_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "venda_loja_virtual_fk"
	    )
	)
	private VendaCompraLojaVisrtualEntity compraLojaVisrtual;

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

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public VendaCompraLojaVisrtualEntity getCompraLojaVisrtual() {
		return compraLojaVisrtual;
	}

	public void setCompraLojaVisrtual(VendaCompraLojaVisrtualEntity compraLojaVisrtual) {
		this.compraLojaVisrtual = compraLojaVisrtual;
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
		IntemVendaLojaEntity other = (IntemVendaLojaEntity) obj;
		return Objects.equals(id, other.id);
	}

}
