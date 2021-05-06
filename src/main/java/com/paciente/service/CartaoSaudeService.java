package com.paciente.service;


import com.paciente.domain.model.CartaoSaude;
import com.paciente.domain.request.CartaoSaudeRequest;


public interface CartaoSaudeService {
	
	CartaoSaude save(CartaoSaudeRequest cartaoSaudeRequest) throws Exception;
	
	public  CartaoSaude update(CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId) throws Exception;
	
	void delete(Long cartaoSaudeId, Long pacienteId) throws Exception;

}
