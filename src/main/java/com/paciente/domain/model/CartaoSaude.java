package com.paciente.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_cartao_saude")
public class CartaoSaude {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "convenio_id")
	private Long convenioId;
	
	@Column(name = "convenio", nullable = false)
	private String convenio;
	
	@Column(name = "tp_contrato", nullable = false)
	private String tipoContrato;
	
	@Column(name = "rede")
	private String rede;
	
	@Column(name = "nr_carteira", unique = true)
	private Long numeroCarteira;
	
	@Column(name = "validade", nullable = false)
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
