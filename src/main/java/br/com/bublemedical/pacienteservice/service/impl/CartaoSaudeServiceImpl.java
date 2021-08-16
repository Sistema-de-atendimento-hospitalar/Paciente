package br.com.bublemedical.pacienteservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.bublemedical.pacienteservice.domain.mapper.CartaoSaudeMapper;
import br.com.bublemedical.pacienteservice.domain.model.CartaoSaude;
import br.com.bublemedical.pacienteservice.domain.model.Paciente;
import br.com.bublemedical.pacienteservice.domain.request.CartaoSaudeRequest;
import br.com.bublemedical.pacienteservice.exception.NotFoundException;
import br.com.bublemedical.pacienteservice.repository.CartaoSaudeRepository;
import br.com.bublemedical.pacienteservice.repository.PacienteRepository;
import br.com.bublemedical.pacienteservice.service.CartaoSaudeService;
import br.com.bublemedical.pacienteservice.service.PacienteService;

@Service
public class CartaoSaudeServiceImpl implements CartaoSaudeService {

	@Autowired
	private CartaoSaudeRepository cartaoSaudeRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private PacienteService pacienteService;

	@Override
	public CartaoSaude save(CartaoSaudeRequest cartaoSaudeRequest) {
		CartaoSaude cartaoSaude = CartaoSaudeMapper.toModel(cartaoSaudeRequest);
		return cartaoSaudeRepository.save(cartaoSaude);
	}

	@Override
	public CartaoSaude update(CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId) {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		CartaoSaude cartaoSaude = cartaoSaudeRepository.save(CartaoSaudeMapper.toModel(cartaoSaudeRequest));

		paciente.setCartaoSaude(cartaoSaude);
		return cartaoSaudeRepository.save(cartaoSaude);
	}

	@Override
	public void delete(Long pacienteId, Long cartaoSaudeId) {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		paciente.setCartaoSaude(null);
		
		pacienteRepository.save(paciente);
		
		try {
			cartaoSaudeRepository.deleteById(cartaoSaudeId);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("Convênio não encontrado", e);
		}
	}

}
