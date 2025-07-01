package com.jopaulo.lojavirtual.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_FORMA_PAGAMENTO")
@SequenceGenerator(name = "SEQ_FORMA_PAGAMENTO", sequenceName = "SEQ_FORMA_PAGAMENTO", allocationSize = 1, initialValue = 1)
public class FormaPagamentoEntity implements Serializable {

	private static final long serialVersionUID = 7638530716754480687L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FORMA_PAGAMENTO")
	private Long id;
	
	private String descricao;

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

	@Override
	public String toString() {
		return "FormaPagamentoEntity [id=" + id + "]";
	}
}
