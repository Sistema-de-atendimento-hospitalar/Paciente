package com.paciente.domain.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;

import com.paciente.domain.model.Paciente;

public class PutPacienteRequest implements Serializable {

	private static final long serialVersionUID = 9006236584152352969L;

	@CPF
	@NotNull(message = "CPF não pode ser nula")
	@NotBlank(message = "CPF não pode está em branco")
	private String cpf;

	@NotNull(message = "Nome não pode ser nula")
	@NotBlank(message = "Nome não pode está em branco")
	private String nome;

	@NotNull(message = "Email não pode ser nulo")
	@Email(message = "Email não é válido")
	private String email;

	@NotNull(message = "A data de nascimento não pode ser nulo")
	private LocalDate dtNascimento;

	@NotNull(message = "O sexo não pode ser nulo")
	@NotBlank(message = "O sexo não pode está em branco")
	private String sexo;

	@NotNull(message = "O RG não pode ser nulo")
	@NotBlank(message = "O RG não pode está em branco")
	private String rg;

	@NotNull(message = "O Orgão Expedidor não pode ser nulo")
	@NotBlank(message = "O Orgão Expedidor não pode está em branco")
	private String orgExpedidorRg;

	@NotNull(message = "A Emissão do RG não pode ser nulo")
	private LocalDate emissaoRg;

	@NotNull(message = "Não pode ser nulo")
	private List<EnderecoRequest> enderecos;
	
	@NotNull(message = "Não pode ser nulo")
	private CartaoSaudeRequest cartaoSaude;
	
	@NotNull(message = "Não pode ser nulo")
	private List<TelefoneRequest> telefones;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgExpedidorRg() {
		return orgExpedidorRg;
	}

	public void setOrgExpedidorRg(String orgExpedidorRg) {
		this.orgExpedidorRg = orgExpedidorRg;
	}

	public LocalDate getEmissaoRg() {
		return emissaoRg;
	}

	public void setEmissaoRg(LocalDate emissaoRg) {
		this.emissaoRg = emissaoRg;
	}

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
