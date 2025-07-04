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
@Table(name = "TB_IMAGEM_PRODUTO")
@SequenceGenerator(name = "SEQ_IMAGEM_PRODUTO", sequenceName = "SEQ_IMAGEM_PRODUTO", allocationSize = 1, initialValue = 1)
public class ImagemProduto implements Serializable{

	private static final long serialVersionUID = 7087467941584315045L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IMAGEM_PRODUTO")
	private Long id;
	
	@Column(columnDefinition = "text")
	private String imagemOriginal;
	
	@Column(columnDefinition = "text")
	private String imagemMiniatura;
	
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

	public String getImagemOriginal() {
		return imagemOriginal;
	}

	public void setImagemOriginal(String imagemOriginal) {
		this.imagemOriginal = imagemOriginal;
	}

	public String getImagemMiniatura() {
		return imagemMiniatura;
	}

	public void setImagemMiniatura(String imagemMiniatura) {
		this.imagemMiniatura = imagemMiniatura;
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
		ImagemProduto other = (ImagemProduto) obj;
		return Objects.equals(id, other.id);
	}

}
