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
		/*String part1 = email.substring(0, 4);
		String part2 = email.substring(email.length() - 4, email.length());
		
		email = email.replace(part1, "*".repeat(4));
		email = email.replace(part2, "*".repeat(4));*/
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
