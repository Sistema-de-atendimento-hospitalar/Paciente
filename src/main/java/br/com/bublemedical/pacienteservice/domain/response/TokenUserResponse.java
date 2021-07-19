package br.com.bublemedical.pacienteservice.domain.response;

public class TokenUserResponse {

	private String cpf;
	private String email;

	public TokenUserResponse(String cpf, String email) {
		super();
		this.cpf = cpf;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
