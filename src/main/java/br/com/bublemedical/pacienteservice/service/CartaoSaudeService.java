package br.com.bublemedical.pacienteservice.service;

import br.com.bublemedical.pacienteservice.domain.model.CartaoSaude;
import br.com.bublemedical.pacienteservice.domain.request.CartaoSaudeRequest;


public interface CartaoSaudeService {
	
	CartaoSaude save(CartaoSaudeRequest cartaoSaudeRequest) throws Exception;
	
	public  CartaoSaude update(CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId) throws Exception;
	
	void delete(Long cartaoSaudeId, Long pacienteId) throws Exception;

}
