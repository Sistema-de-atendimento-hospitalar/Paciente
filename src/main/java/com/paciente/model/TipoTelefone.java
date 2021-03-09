package com.paciente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_tipo_telefone")
public class TipoTelefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tp_telefone_id")
	private Integer tipoTelefoneId;
	
	@Column(name = "ds_tipo_telefone")
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
