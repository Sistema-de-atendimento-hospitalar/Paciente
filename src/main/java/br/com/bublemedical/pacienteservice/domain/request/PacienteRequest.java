package br.com.bublemedical.pacienteservice.domain.request;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;

import br.com.bublemedical.pacienteservice.domain.model.Paciente;

public class PacienteRequest implements Serializable {

	private static final long serialVersionUID = 9006236584152352969L;

	@CPF
	@NotNull(message = "CPF não pode ser nula")
	@NotBlank(message = "CPF não pode está em branco")
	@Length(min = 11,  max = 11)
	private String cpf;

	@NotNull(message = "Nome não pode ser nula")
	@NotBlank(message = "Nome não pode está em branco")
	private String nome;

	@NotNull(message = "Email não pode ser nulo")
	@Email(message = "Email não é válido")
	private String email;

	@NotNull(message = "A data de nascimento não pode ser nulo")
	@Past
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

	@Past
	@NotNull(message = "A Emissão do RG não pode ser nulo")
	private LocalDate dtEmissaoRg;
	
	@NotNull(message = "O estado expedidor não pode ser nulo")
	@NotBlank(message = "O estado expedidor não pode está em branco")
	private String estadoExpedidor;
	
	private String deficiencia;

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

	public LocalDate getDtEmissaoRg() {
		return dtEmissaoRg;
	}

	public void setDtEmissaoRg(LocalDate dtEmissaoRg) {
		this.dtEmissaoRg = dtEmissaoRg;
	}
	
	public String getEstadoExpedidor() {
		return estadoExpedidor;
	}

	public void setEstadoExpedidor(String estadoExpedidor) {
		this.estadoExpedidor = estadoExpedidor;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public static Paciente toModel(PacienteRequest pacienteRequest) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(pacienteRequest, Paciente.class);
	}

}
