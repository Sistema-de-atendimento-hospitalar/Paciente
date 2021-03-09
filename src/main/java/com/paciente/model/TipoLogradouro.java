package com.paciente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_tipo_logradouro")
public class TipoLogradouro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tp_logradouro_id")
	private Long tpLogradouroId;
	
	@Column(name = "ds_tipo_logradouro")
	private String dsTpLogradouro;
	
	

	public Long getTpLogradouroId() {
		return tpLogradouroId;
	}

	public void setTpLogradouroId(Long tpLogradouroId) {
		this.tpLogradouroId = tpLogradouroId;
	}

	public String getDsTpLogradouro() {
		return dsTpLogradouro;
	}

	public void setDsTpLogradouro(String dsTpLogradouro) {
		this.dsTpLogradouro = dsTpLogradouro;
	}

}
