package com.jopaulo.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_NOTA_FISCAL_COMPRA")
@SequenceGenerator(name = "SEQ_NOTA_FISCAL_COMPRA", sequenceName = "SEQ_NOTA_FISCAL_COMPRA", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompraEntity implements Serializable{

	
	private static final long serialVersionUID = -8497033978211021674L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTA_FISCAL_COMPRA")
	private Long id;
	
	@Column(nullable = false)
	private String numeroNota;
	
	@Column(nullable = false)
	private String serieNota;
	
	private String descricao;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;
	
	@Column(nullable = false)
	private BigDecimal valorIcms;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCompra;	
	
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
			name = "conta_pagar_id", 
			nullable = false, 
		    foreignKey = @ForeignKey(
	    		value = ConstraintMode.CONSTRAINT, 
	    		name = "conta_pagar_fk"
			)
	)
	private ContaPagarEntity contaPagarEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getSerieNota() {
		return serieNota;
	}

	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(BigDecimal valorIcms) {
		this.valorIcms = valorIcms;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

	public ContaPagarEntity getContaPagarEntity() {
		return contaPagarEntity;
	}

	public void setContaPagarEntity(ContaPagarEntity contaPagarEntity) {
		this.contaPagarEntity = contaPagarEntity;
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
		NotaFiscalCompraEntity other = (NotaFiscalCompraEntity) obj;
		return Objects.equals(id, other.id);
	}

}
