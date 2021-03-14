package com.paciente.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.paciente.domain.mapper.EnderecoMapper;
import com.paciente.domain.mapper.TelefoneMapper;
import com.paciente.domain.model.CartaoSaude;
import com.paciente.domain.model.Endereco;
import com.paciente.domain.model.Paciente;
import com.paciente.domain.model.Telefone;
import com.paciente.domain.request.CartaoSaudeRequest;
import com.paciente.domain.request.EnderecoRequest;
import com.paciente.domain.request.PacienteRequest;
import com.paciente.domain.request.TelefoneRequest;
import com.paciente.domain.response.PacienteResponse;
import com.paciente.repository.PacienteRepository;
import com.paciente.service.CartaoSaudeService;
import com.paciente.service.EnderecoService;
import com.paciente.service.PacienteService;
import com.paciente.service.TelefoneService;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private CartaoSaudeService cartaoSaudeService;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private TelefoneService telefoneService;

	@Override
	public PacienteResponse findByCpf(String cpf) {
		Paciente paciente = pacienteRepository.findByCpf(cpf).orElseThrow(IllegalArgumentException::new);
		return PacienteResponse.toDto(paciente);
	}

	@Override
	public Page<PacienteResponse> findAll(PageRequest pageable) {
		return pacienteRepository.findAll(pageable).map(PacienteResponse::toDto);
	}

	@Override
	public PacienteResponse save(PacienteRequest pacienteRequest) throws Exception {
		Paciente paciente = PacienteRequest.toModel(pacienteRequest);

		try {
			paciente = pacienteRepository.save(paciente);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Error sistemico", e);
		}
		return PacienteResponse.toDto(paciente);
	}

	@Override
	public PacienteResponse update(PacienteRequest pacienteRequest, Long pacienteId) throws Exception {
		PacienteResponse pacienteDto = findById(pacienteId);
		if (pacienteDto != null) {
			BeanUtils.copyProperties(pacienteRequest, pacienteDto, "pacienteId");
		}

		return null;
	}

	@Override
	public void delete(Long pacienteId) throws Exception {
		PacienteResponse pacienteDto = findById(pacienteId);
		if (pacienteDto != null) {
			pacienteRepository.deleteById(pacienteId);
		}

	}

	@Override
	public PacienteResponse findById(Long pacienteId) throws Exception {
		return pacienteRepository.findById(pacienteId).map(PacienteResponse::toDto).orElseThrow(Exception::new);
	}

	@Override
	public void createAddress(List<EnderecoRequest> enderecoRequest, Long pacienteId) throws Exception {
		Paciente paciente = findByPacienteId(pacienteId);

		List<Endereco> enderecos = enderecoRequest.stream().map(EnderecoMapper::toModel).collect(Collectors.toList());
		enderecos.forEach(endereco -> endereco.setPaciente(paciente));

		enderecoService.save(enderecos);

	}

	@Override
	public void createTelefone(List<TelefoneRequest> telefoneRequest, Long pacienteId) throws Exception {
		Paciente paciente = findByPacienteId(pacienteId);
		
		List<Telefone> telefones = telefoneRequest.stream().map(TelefoneMapper::toModel).collect(Collectors.toList());
		telefones.forEach(telefone -> telefone.setPaciente(paciente));
		
		telefoneService.save(telefones);
	}

	@Override
	public void createCartaoSaude(CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId) throws Exception {
		CartaoSaude cartaoSaude = cartaoSaudeService.save(cartaoSaudeRequest);

		Paciente paciente = findByPacienteId(pacienteId);
		paciente.setCartaoSaude(cartaoSaude);

		pacienteRepository.save(paciente);
	}

	private Paciente findByPacienteId(Long pacienteId) throws Exception {
		return pacienteRepository.findById(pacienteId).orElseThrow(Exception::new);
	}

}
