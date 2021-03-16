package com.paciente.domain.request;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartaoSaudeRequest implements Serializable {
	
	private static final long serialVersionUID = 2877536737944486333L;
	
	private Long convenioId;

	@NotNull(message = "convenio não pode ser nulo")
	@NotBlank(message = "convenio não pode está em branco")
	private String convenio;

	@NotNull(message = "O tipo de contrato não pode ser nulo")
	@NotBlank(message = "O tipo de contrato não pode está em branco")
	private String tipoContrato;

	@NotNull(message = "rede não pode ser nulo")
	@NotBlank(message = "rede não pode está em branco")
	private String rede;

	@NotNull(message = "O número da carteira não pode ser nulo")
	private Long numeroCarteira;

	@NotNull(message = "A validade não pode ser nulo")
	private LocalDate validade;
	
	public Long getConvenioId() {
		return convenioId;
	}

	public void setConvenioId(Long convenioId) {
		this.convenioId = convenioId;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getRede() {
		return rede;
	}

	public void setRede(String rede) {
		this.rede = rede;
	}

	public Long getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(Long numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

}
