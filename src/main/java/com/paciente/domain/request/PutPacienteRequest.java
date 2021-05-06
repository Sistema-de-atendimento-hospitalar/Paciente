package com.paciente.domain.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.paciente.domain.model.Paciente;

public class PutPacienteRequest extends PacienteRequest implements Serializable {

	private static final long serialVersionUID = 9006236584152352969L;


	//@NotNull(message = "Não pode ser nulo")
	private List<EnderecoRequest> enderecos;
	
	//@NotNull(message = "Não pode ser nulo")
	private CartaoSaudeRequest cartaoSaude;
	
	//@NotNull(message = "Não pode ser nulo")
	private List<TelefoneRequest> telefones;
	
	public List<EnderecoRequest> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoRequest> enderecos) {
		this.enderecos = enderecos;
	}

	public CartaoSaudeRequest getCartaoSaude() {
		return cartaoSaude;
	}

	public void setCartaoSaude(CartaoSaudeRequest cartaoSaude) {
		this.cartaoSaude = cartaoSaude;
	}

	public List<TelefoneRequest> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneRequest> telefones) {
		this.telefones = telefones;
	}

	public static Paciente toModel(PutPacienteRequest pacienteRequest) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(pacienteRequest, Paciente.class);
	}

}
