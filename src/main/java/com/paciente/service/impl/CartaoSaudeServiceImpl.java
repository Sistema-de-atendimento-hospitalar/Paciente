package com.paciente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paciente.domain.mapper.CartaoSaudeMapper;
import com.paciente.domain.model.CartaoSaude;
import com.paciente.domain.request.CartaoSaudeRequest;
import com.paciente.repository.CartaoSaudeRepository;
import com.paciente.service.CartaoSaudeService;

@Service
public class CartaoSaudeServiceImpl implements CartaoSaudeService {

	@Autowired
	private CartaoSaudeRepository cartaoSaudeRepository;

	@Override
	public CartaoSaude save(CartaoSaudeRequest cartaoSaudeRequest) throws Exception {
		CartaoSaude cartaoSaude = CartaoSaudeMapper.toModel(cartaoSaudeRequest);
		return cartaoSaudeRepository.save(cartaoSaude);
	}

}
