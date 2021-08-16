package br.com.bublemedical.pacienteservice.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_cartao_saude", uniqueConstraints = { @UniqueConstraint(columnNames = { "nr_carteira", "convenio" }) })
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

	@Column(name = "nr_carteira")
	private Long numeroCarteira;

	@Column(name = "validade", nullable = false)
	private LocalDate dtValidade;

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

	public LocalDate getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(LocalDate validade) {
		this.dtValidade = validade;
	}

}
