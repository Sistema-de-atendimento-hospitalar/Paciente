package com.paciente.request;

public class TipoTelefoneRequest {

	private Integer tipoTelefoneId;

	private String descTipoTelefone;

	public String getDescTipoTelefone() {
		return descTipoTelefone;
	}

	public void setDescTipoTelefone(String descTipoTelefone) {
		this.descTipoTelefone = descTipoTelefone;
	}

	public Integer getTipoTelefoneId() {
		return tipoTelefoneId;
	}

	public void setTipoTelefoneId(Integer tipoTelefoneId) {
		this.tipoTelefoneId = tipoTelefoneId;
	}

}
