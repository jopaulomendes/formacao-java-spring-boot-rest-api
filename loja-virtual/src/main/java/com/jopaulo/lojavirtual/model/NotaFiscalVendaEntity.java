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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_NOTA_FISCAL_VENDA")
@SequenceGenerator(name = "SEQ_NOTA_FISCAL_VENDA", sequenceName = "SEQ_NOTA_FISCAL_VENDA", allocationSize = 1, initialValue = 1)
public class NotaFiscalVendaEntity implements Serializable{

	private static final long serialVersionUID = 4243028147750730375L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTA_FISCAL_VENDA")
	private Long id;
	
	private String numero;
	
	private String serie;
	
	private String tipo;
	
	@Column(columnDefinition = "text")
	private String xml;
	
	@Column(columnDefinition = "text")
	private String pdf;
	
	@OneToOne
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
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
		NotaFiscalVendaEntity other = (NotaFiscalVendaEntity) obj;
		return Objects.equals(id, other.id);
	}

	public VendaCompraLojaVisrtualEntity getCompraLojaVisrtual() {
		return compraLojaVisrtual;
	}

	public void setCompraLojaVisrtual(VendaCompraLojaVisrtualEntity compraLojaVisrtual) {
		this.compraLojaVisrtual = compraLojaVisrtual;
	}
}
