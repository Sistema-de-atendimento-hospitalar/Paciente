package br.com.bublemedical.pacienteservice.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException(String mensagem) {
		super(mensagem);
	}

	public NotFoundException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}
