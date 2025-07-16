package com.jopaulo.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.jopaulo.lojavirtual.enums.StatusContaPagarEnum;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "TB_CONTA_PAGAR")
@SequenceGenerator(name = "SEQ_CONTA_PAGAR", sequenceName = "SEQ_CONTA_PAGAR", allocationSize = 1, initialValue = 1)
public class ContaPagarEntity implements Serializable {

	private static final long serialVersionUID = 8653795609475066596L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTA_PAGAR")
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusContaPagarEnum contaPagar;
	
	@ManyToOne(targetEntity = PessoaEntity.class)
	@JoinColumn(name = "pessoa_id", nullable = false, 
		foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private PessoaEntity pessoa;
	
	@ManyToOne(targetEntity = PessoaEntity.class)
	@JoinColumn(name = "pessoa_fornecedor_id", nullable = false, 
		foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fornecedor_fk"))
	private PessoaEntity pessoaFornecedor;

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

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
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

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
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
		ContaPagarEntity other = (ContaPagarEntity) obj;
		return Objects.equals(id, other.id);
	}

	public PessoaEntity getPessoaFornecedor() {
		return pessoaFornecedor;
	}

	public void setPessoaFornecedor(PessoaEntity pessoaFornecedor) {
		this.pessoaFornecedor = pessoaFornecedor;
	}

	public StatusContaPagarEnum getContaPagar() {
		return contaPagar;
	}

	public void setContaPagar(StatusContaPagarEnum contaPagar) {
		this.contaPagar = contaPagar;
	}
	
}
