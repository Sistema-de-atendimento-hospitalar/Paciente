package com.paciente.domain.response;

public class TelefoneResponse {

	private int tpTelefoneId;
	private String descTipoTelefone;
	
	public TelefoneResponse(int code, String desc) {
		super();
		this.tpTelefoneId = code;
		this.descTipoTelefone = desc;
	}

	public int getTpTelefoneId() {
		return tpTelefoneId;
	}

	public void setTpTelefoneId(int tpTelefoneId) {
		this.tpTelefoneId = tpTelefoneId;
	}

	public String getDescTipoTelefone() {
		return descTipoTelefone;
	}

	public void setDescTipoTelefone(String descTipoTelefone) {
		this.descTipoTelefone = descTipoTelefone;
	}

	

}
