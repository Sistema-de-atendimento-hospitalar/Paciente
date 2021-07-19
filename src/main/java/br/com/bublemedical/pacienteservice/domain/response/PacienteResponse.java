package br.com.bublemedical.pacienteservice.domain.response;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.bublemedical.pacienteservice.domain.dto.EnderecoDto;
import br.com.bublemedical.pacienteservice.domain.dto.TelefoneDto;
import br.com.bublemedical.pacienteservice.domain.model.Paciente;
import br.com.bublemedical.pacienteservice.domain.request.CartaoSaudeRequest;

public class PacienteResponse {

	private Long pacienteId;
	private String cpf;
	private String nome;
	private String email;
	private LocalDate dtNascimento;
	private String sexo;
	private String rg;
	private String orgExpedidorRg;
	private LocalDate dtEmissaoRg;
	private String estadoExpedidor;
	private List<EnderecoDto> enderecos;
	private CartaoSaudeRequest cartaoSaude;
	private List<TelefoneDto> telefones;
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

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}
	
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
		String part1 = email.substring(0, 4);
		String part2 = email.substring(email.length() - 4, email.length());
		
		email = email.replace(part1, "*".repeat(4));
		email = email.replace(part2, "*".repeat(4));
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
