package com.paciente.service;

import com.paciente.domain.model.CartaoSaude;
import com.paciente.domain.request.CartaoSaudeRequest;

public interface CartaoSaudeService {
	
	CartaoSaude save(CartaoSaudeRequest cartaoSaudeRequest) throws Exception;

}
