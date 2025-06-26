package com.jopaulo.lojavirtual.enums;

public enum TipoEnderecoEnum {

	COBRANCA("Cobrança"),
	ENTREGA("Entrega");
	
	private String descricao;
	
	private TipoEnderecoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
