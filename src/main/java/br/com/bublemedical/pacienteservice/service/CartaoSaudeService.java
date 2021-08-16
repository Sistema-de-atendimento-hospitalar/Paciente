package br.com.bublemedical.pacienteservice.service;

import br.com.bublemedical.pacienteservice.domain.model.CartaoSaude;
import br.com.bublemedical.pacienteservice.domain.request.CartaoSaudeRequest;


public interface CartaoSaudeService {
	
	CartaoSaude save(CartaoSaudeRequest cartaoSaudeRequest);
	
	public  CartaoSaude update(CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId);
	
	void delete(Long pacienteId, Long cartaoSaudeId);

}
