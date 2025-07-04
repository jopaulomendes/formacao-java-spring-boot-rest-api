package com.jopaulo.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_CUPOM_DESCONTO")
@SequenceGenerator(name = "SEQ_CUPOM_DESCONTO", sequenceName = "SEQ_CUPOM_DESCONTO", allocationSize = 1, initialValue = 1)
public class CupomDescontoEntity implements Serializable {

	private static final long serialVersionUID = -1377615531694281917L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUPOM_DESCONTO")
	private Long id;
	
	private String descricao;
	
	private BigDecimal valorReal;
	
	private BigDecimal valorPorcentagem;
	
	@Temporal(TemporalType.DATE)
	private Date dataV;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorReal() {
		return valorReal;
	}

	public void setValorReal(BigDecimal valorReal) {
		this.valorReal = valorReal;
	}

	public BigDecimal getValorPorcentagem() {
		return valorPorcentagem;
	}

	public void setValorPorcentagem(BigDecimal valorPorcentagem) {
		this.valorPorcentagem = valorPorcentagem;
	}

	public Date getDataV() {
		return dataV;
	}

	public void setDataV(Date dataV) {
		this.dataV = dataV;
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
		CupomDescontoEntity other = (CupomDescontoEntity) obj;
		return Objects.equals(id, other.id);
	}
}
