package br.com.bublemedical.pacienteservice.domain.dto;

import br.com.bublemedical.pacienteservice.domain.enumerate.TipoContato;

public class ContatoDto {

	private TipoContato tipoContato;
	private String contatoAdress;
	
	public TipoContato getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}
	public String getContatoAdress() {
		return contatoAdress;
	}
	public void setContatoAdress(String contatoAdress) {
		this.contatoAdress = contatoAdress;
	}
	
	
}
