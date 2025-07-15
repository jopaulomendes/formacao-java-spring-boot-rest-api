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
@Table(name = "TB_STATUS_RASTREIO")
@SequenceGenerator(name = "SEQ_STATUS_RASTREIO", sequenceName = "SEQ_STATUS_RASTREIO", allocationSize = 1, initialValue = 1)
public class StatusRastreioEntity implements Serializable {

	private static final long serialVersionUID = 8214579251127419324L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STATUS_RASTREIO")
	private Long id;
	
	private String centroDistribuicao;

	private String cidade;
	
	private String estado;

	private String status;
	
	@ManyToOne
	@JoinColumn(
	    name = "venda_compra_loja_vistual_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "venda_compra_loja_vistual_fk"
	    )
	)
	private VendaCompraLojaVisrtualEntity compraLojaVisrtual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCentroDistribuicao() {
		return centroDistribuicao;
	}

	public void setCentroDistribuicao(String centroDistribuicao) {
		this.centroDistribuicao = centroDistribuicao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		StatusRastreioEntity other = (StatusRastreioEntity) obj;
		return Objects.equals(id, other.id);
	}
}
