package com.paciente.domain.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TelefoneRequest {
	
	private Long telefoneId;
	
	@NotNull(message = "O número de telefone não pode ser nula")
	@NotBlank(message = "O número de telefone não pode está em branco")
	private String numTelefone;

	@NotNull(message = "DDD não pode ser nula")
	@NotBlank(message = "DDD não pode está em branco")
	private Integer numDdd;
	
	private TipoTelefoneRequest tipoTelefone;
	
	public Long getTelefoneId() {
		return telefoneId;
	}

	public void setTelefoneId(Long telefoneId) {
		this.telefoneId = telefoneId;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public Integer getNumDdd() {
		return numDdd;
	}

	public void setNumDdd(Integer numDdd) {
		this.numDdd = numDdd;
	}

	public TipoTelefoneRequest getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefoneRequest tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

}
