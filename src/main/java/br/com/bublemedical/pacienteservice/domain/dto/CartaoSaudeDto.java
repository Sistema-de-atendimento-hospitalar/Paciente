package br.com.bublemedical.pacienteservice.domain.dto;

import java.time.LocalDate;

public class CartaoSaudeDto {

	private String convenio;
	private String tipoContrato;
	private String rede;
	private Long numeroCarteira;
	private LocalDate dtValidade;

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

	public LocalDate getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(LocalDate validade) {
		this.dtValidade = validade;
	}

}
