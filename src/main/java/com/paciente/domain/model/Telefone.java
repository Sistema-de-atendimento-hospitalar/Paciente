package com.paciente.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paciente.domain.enumerate.TipoTelefoneEnum;

@Entity
@Table(name = "t_telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telefone_id")
	private Long telefoneId;
	
	@Column(name = "nr_telefone", nullable = false)
	private String numTelefone;
	
	@Column(name = "nr_ddd", nullable = false)
	private Integer numDdd;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone", columnDefinition = "varchar(15)")
	private TipoTelefoneEnum tipoTelefone;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", nullable = false)
	@JsonIgnore
	private Paciente paciente;

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


	public Long getTelefoneId() {
		return telefoneId;
	}

	public void setTelefoneId(Long telefoneId) {
		this.telefoneId = telefoneId;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public TipoTelefoneEnum getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefoneEnum tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
}
