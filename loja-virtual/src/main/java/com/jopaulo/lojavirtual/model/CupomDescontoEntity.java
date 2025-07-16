package com.jopaulo.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
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
	
	@Column(nullable = false)
	private String codigoDesconto;
	
	private BigDecimal valorReal;
	
	private BigDecimal valorPorcentagem;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataValidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCodigoDesconto() {
		return codigoDesconto;
	}

	public void setCodigoDesconto(String codigoDesconto) {
		this.codigoDesconto = codigoDesconto;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
}
