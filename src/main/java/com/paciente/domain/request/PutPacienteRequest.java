package com.paciente.domain.request;

import java.io.Serializable;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.paciente.domain.dto.EnderecoDto;
import com.paciente.domain.dto.TelefoneDto;
import com.paciente.domain.model.Paciente;

public class PutPacienteRequest extends PacienteRequest implements Serializable {

	private static final long serialVersionUID = 9006236584152352969L;

	private List<EnderecoDto> enderecos;
	private CartaoSaudeRequest cartaoSaude;
	private List<TelefoneDto> telefones;
	
	
	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}

	public CartaoSaudeRequest getCartaoSaude() {
		return cartaoSaude;
	}

	public void setCartaoSaude(CartaoSaudeRequest cartaoSaude) {
		this.cartaoSaude = cartaoSaude;
	}

	public List<TelefoneDto> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDto> telefones) {
		this.telefones = telefones;
	}

	public static Paciente toModel(PutPacienteRequest pacienteRequest) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(pacienteRequest, Paciente.class);
	}

}
