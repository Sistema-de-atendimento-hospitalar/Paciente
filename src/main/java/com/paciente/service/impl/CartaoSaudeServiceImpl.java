package com.paciente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paciente.domain.mapper.CartaoSaudeMapper;
import com.paciente.domain.model.CartaoSaude;
import com.paciente.domain.model.Paciente;
import com.paciente.domain.request.CartaoSaudeRequest;
import com.paciente.repository.CartaoSaudeRepository;
import com.paciente.service.CartaoSaudeService;
import com.paciente.service.PacienteService;

@Service
public class CartaoSaudeServiceImpl implements CartaoSaudeService {

	@Autowired
	private CartaoSaudeRepository cartaoSaudeRepository;
	
	@Autowired
	private PacienteService pacienteService;

	@Override
	public CartaoSaude save(CartaoSaudeRequest cartaoSaudeRequest) throws Exception {
		CartaoSaude cartaoSaude = CartaoSaudeMapper.toModel(cartaoSaudeRequest);
		return cartaoSaudeRepository.save(cartaoSaude);
	}
	
	@Override
	public CartaoSaude update(CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId) throws Exception {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		CartaoSaude cartaoSaude = cartaoSaudeRepository.save(CartaoSaudeMapper.toModel(cartaoSaudeRequest));
		
		paciente.setCartaoSaude(cartaoSaude);
		return cartaoSaudeRepository.save(cartaoSaude);
	}

	@Override
	public void delete(Long cartaoSaudeId, Long pacienteId) throws Exception {
		cartaoSaudeRepository.deleteById(cartaoSaudeId);	
	}

}
