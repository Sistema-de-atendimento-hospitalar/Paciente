package com.paciente.domain.response;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.paciente.domain.model.Paciente;
import com.paciente.domain.request.CartaoSaudeRequest;
import com.paciente.domain.request.EnderecoRequest;
import com.paciente.domain.request.TelefoneRequest;

public class PacienteResponse {

	private Long pacienteId;
	private Long cpf;
	private String nome;
	private String email;
	private LocalDate dtNascimento;
	private String sexo;
	private String rg;
	private String orgExpedidorRg;
	private LocalDate emissaoRg;
	private List<EnderecoRequest> enderecos;
	private CartaoSaudeRequest cartaoSaude;
	private List<TelefoneRequest> telefones;
	private String deficiencia;

//	public PacienteDto() {
//		super();
//	}

//	public PacienteDto(Paciente paciente) {
//		this.cpf = paciente.getCpf();
//		this.nome = paciente.getNome();
//		this.email = paciente.getEmail();
//		this.dtNascimento = paciente.getDtNascimento();
//		this.sexo = paciente.getSexo();
//		this.rg = paciente.getRg();
//		this.orgExpedidoRg = paciente.getOrgExpedidor();
//		this.emissaoRg = paciente.getEmissaoRg();
//	}
	

	public Long getCpf() {
		return cpf;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public void setCpf(Long cpf) {
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
	
	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public static PacienteResponse toDto(Paciente paciente) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(paciente, PacienteResponse.class);
	}

}
