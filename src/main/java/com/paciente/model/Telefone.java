package com.paciente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telefone_id")
	private Long telefoneId;
	
	@Column(name = "nr_telefone")
	private String numTelefone;
	
	@Column(name = "nr_ddd")
	private Integer numDdd;

	@OneToOne
	@JoinColumn(name = "tp_telefone_id")
	private TipoTelefone tipoTelefone;

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

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Long getTelefoneId() {
		return telefoneId;
	}

	public void setTelefoneId(Long telefoneId) {
		this.telefoneId = telefoneId;
	}
	

}
