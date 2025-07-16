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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_CP_LOJA_VIRTUAL")
@SequenceGenerator(name = "SEQ_CP_LOJA_VIRTUAL", sequenceName = "SEQ_CP_LOJA_VIRTUAL", allocationSize = 1, initialValue = 1)
public class VendaCompraLojaVisrtualEntity implements Serializable{

	private static final long serialVersionUID = -2450008681313682014L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CP_LOJA_VIRTUAL")
	private Long id;
	
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
	    name = "endereco_entrega_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "endereco_entrega_fk"
	    )
	)
	private EnderecoEntity enderecoEntrega;

	@ManyToOne
	@JoinColumn(
	    name = "endereco_cobranca_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "endereco_cobranca_fk"
	    )
	)
	private EnderecoEntity enderecoCobranca;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;

	private BigDecimal valorDesconto;
	
	@ManyToOne
	@JoinColumn(
	    name = "forma_pagamento_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "forma_pagamento_fk"
	    )
	)
	private FormaPagamentoEntity formaPagamento;
	
	@OneToOne
	@JoinColumn(
	    name = "nota_fiscal_venda_id",
	    nullable = false,
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "nota_fiscal_venda_fk"
	    )
	)
	private NotaFiscalVendaEntity notaFiscalVenda;
	
	@ManyToOne
	@JoinColumn(
	    name = "cupom_desconto_id",
	    foreignKey = @ForeignKey(
	        value = ConstraintMode.CONSTRAINT,
	        name = "cupom_desconto_fk"
	    )
	)
	private CupomDescontoEntity cupomDesconto;
	
	@Column(nullable = false)
	private BigDecimal valorFrete;
	
	@Column(nullable = false)
	private Integer diaEntrega;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVenda;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;

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

	public EnderecoEntity getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoEntity enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public EnderecoEntity getEnderecoCobranca() {
		return enderecoCobranca;
	}

	public void setEnderecoCobranca(EnderecoEntity enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
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

	public FormaPagamentoEntity getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoEntity formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public NotaFiscalVendaEntity getNotaFiscalVenda() {
		return notaFiscalVenda;
	}

	public void setNotaFiscalVenda(NotaFiscalVendaEntity notaFiscalVenda) {
		this.notaFiscalVenda = notaFiscalVenda;
	}

	public CupomDescontoEntity getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(CupomDescontoEntity cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Integer getDiaEntrega() {
		return diaEntrega;
	}

	public void setDiaEntrega(Integer diaEntrega) {
		this.diaEntrega = diaEntrega;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
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
		VendaCompraLojaVisrtualEntity other = (VendaCompraLojaVisrtualEntity) obj;
		return Objects.equals(id, other.id);
	}
		

}
