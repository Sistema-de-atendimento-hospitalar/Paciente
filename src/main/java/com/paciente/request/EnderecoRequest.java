package com.paciente.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoRequest {

	@NotNull(message = "CEP não pode ser nulo")
	@NotBlank(message = "CEP não pode está em branco")
	private String cep;

	@NotNull(message = "logradouro não pode ser nula")
	@NotBlank(message = "logradouro não pode está em branco")
	private String logradouro;

	@NotBlank(message = "numImovel não pode está em branco")
	@NotNull(message = "numImovel não pode ser nulo")
	private String numImovel;

	private String dsComplemento;

	@NotNull(message = "O bairro não pode ser nulo")
	@NotBlank(message = "O bairro não pode está em branco")
	private String bairro;

	@NotNull(message = "O cidade não pode ser nulo")
	@NotBlank(message = "O cidade não pode está em branco")
	private String cidade;

	@NotNull(message = "O estado não pode ser nulo")
	@NotBlank(message = "O estado não pode está em branco")
	private String estado;

	@NotBlank(message = "O tipo de logradouro não pode ser nulo")
	private String tipoLogradouro;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumImovel() {
		return numImovel;
	}

	public void setNumImovel(String numImovel) {
		this.numImovel = numImovel;
	}

	public String getDsComplemento() {
		return dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

}
