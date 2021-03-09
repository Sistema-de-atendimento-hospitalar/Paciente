package com.paciente.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paciente_id")
	private Long pacienteId;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "org_expedidor")
	private String orgExpedidorRg;
	
	@Column(name = "emissao_rg")
	private LocalDate emissaoRg;
	
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;
	
	@Column(name = "sexo")
	private String sexo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "convenio_id")
	private CartaoSaude cartaoSaude;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private List<Endereco> enderecos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "telefone_id")
	private List<Telefone> telefones;

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public CartaoSaude getCartaoSaude() {
		return cartaoSaude;
	}

	public void setCartaoSaude(CartaoSaude cartaoSaude) {
		this.cartaoSaude = cartaoSaude;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}
