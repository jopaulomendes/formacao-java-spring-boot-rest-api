package com.jopaulo.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "SEQ_PRODUTO", allocationSize = 1, initialValue = 1)
public class ProdutoEntity implements Serializable{

	private static final long serialVersionUID = -5983185555798677159L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUTO")
	private Long id;
	
	@Column(nullable = false)
	private String tipoUnidade;

	@Column(nullable = false)
	private String nome;

	private Boolean ativo = Boolean.TRUE;
	
	@Column(columnDefinition = "text", length = 2000, nullable = false)
	private String descricao;
	
	//TODO: classe notaItemProduto
	
	@Column(nullable = false)
	private Double peso;
	
	@Column(nullable = false)
	private Double largura;

	@Column(nullable = false)
	private Double altura;

	@Column(nullable = false)
	private Double profundidade;
	
	@Column(nullable = false)
	private BigDecimal valorVenda = BigDecimal.ZERO;
	
	@Column(nullable = false)
	private Integer qtdEstoque = 0;

	private Integer qtdAlertaEstoque = 0;
	
	private String video;
	
	private Boolean alertaEstoque = Boolean.FALSE;
	
	private Integer qtdClique = 0;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getQtdAlertaEstoque() {
		return qtdAlertaEstoque;
	}

	public void setQtdAlertaEstoque(Integer qtdAlertaEstoque) {
		this.qtdAlertaEstoque = qtdAlertaEstoque;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Boolean getAlertaEstoque() {
		return alertaEstoque;
	}

	public void setAlertaEstoque(Boolean alertaEstoque) {
		this.alertaEstoque = alertaEstoque;
	}

	public Integer getQtdClique() {
		return qtdClique;
	}

	public void setQtdClique(Integer qtdClique) {
		this.qtdClique = qtdClique;
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
		ProdutoEntity other = (ProdutoEntity) obj;
		return Objects.equals(id, other.id);
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
