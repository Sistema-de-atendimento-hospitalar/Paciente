package com.paciente.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.paciente.domain.dto.EnderecoDto;
import com.paciente.domain.dto.TelefoneDto;
import com.paciente.domain.mapper.EnderecoMapper;
import com.paciente.domain.mapper.PacienteMapper;
import com.paciente.domain.mapper.TelefoneMapper;
import com.paciente.domain.model.CartaoSaude;
import com.paciente.domain.model.Endereco;
import com.paciente.domain.model.Paciente;
import com.paciente.domain.model.Telefone;
import com.paciente.domain.request.CartaoSaudeRequest;
import com.paciente.domain.request.PacienteRequest;
import com.paciente.domain.request.PutPacienteRequest;
import com.paciente.domain.response.PacienteResponse;
import com.paciente.repository.PacienteRepository;
import com.paciente.repository.TipoTelefoneRepository;
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
	
	@Autowired
	private TipoTelefoneRepository tipoTelefoneRepository;

	@Override
	public PacienteResponse findByCpf(String cpf) {
		PacienteResponse pacienteResponse = null;
		Paciente paciente = pacienteRepository.findByCpf(cpf).orElse(null);
		if (paciente != null) {
			pacienteResponse = PacienteResponse.toDto(paciente); 
		}
		return pacienteResponse;
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
			throw new Exception("constraint violada", e);
		}
		return PacienteResponse.toDto(paciente);
	}

	@Override
	public PacienteResponse update(PacienteRequest pacienteRequest, Long pacienteId) throws Exception {
		Paciente paciente = findByPacienteId(pacienteId);
		BeanUtils.copyProperties(pacienteRequest, paciente, "pacienteId");
		Paciente pacienteUpdate = pacienteRepository.save(paciente);

		return PacienteMapper.toResponse(pacienteUpdate);
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
	public List<Endereco> createAddress(List<EnderecoDto> enderecoRequest, Long pacienteId) throws Exception {
		Paciente paciente = findByPacienteId(pacienteId);

		List<Endereco> enderecos = enderecoRequest.stream().map(EnderecoMapper::toModel).collect(Collectors.toList());
		enderecos.forEach(endereco -> endereco.setPaciente(paciente));

		return enderecoService.save(enderecos);

	}

	@Override
	public List<Telefone> createTelefone(List<TelefoneDto> telefoneRequest, Long pacienteId) throws Exception {
		Paciente paciente = findByPacienteId(pacienteId);
		
		List<Telefone> telefones = telefoneRequest.stream().map(TelefoneMapper::toModel).collect(Collectors.toList());
		telefones.forEach(telefone -> telefone.setPaciente(paciente));
		
		return telefoneService.save(telefones);
	}

	@Override
	public void createCartaoSaude(CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId) throws Exception {
		CartaoSaude cartaoSaude = cartaoSaudeService.save(cartaoSaudeRequest);

		Paciente paciente = findByPacienteId(pacienteId);
		paciente.setCartaoSaude(cartaoSaude);

		pacienteRepository.save(paciente);
	}

	@Override
	public Paciente findByPacienteId(Long pacienteId) throws Exception {
		return pacienteRepository.findById(pacienteId).orElseThrow(Exception::new);
	}

	@Override
	public PacienteResponse updateV2(PutPacienteRequest pacienteRequest, long pacienteId) throws Exception {
//		Paciente paciente = findByPacienteId(pacienteId);
//		BeanUtils.copyProperties(pacienteRequest, paciente, "pacienteId");
//		if (pacienteRequest.getCartaoSaude() != null) {
//			BeanUtils.copyProperties(pacienteRequest.getCartaoSaude(), paciente.getCartaoSaude(), "convenioId");
//		}
//		
//		if (pacienteRequest.getTelefones().size() != paciente.getTelefones().size()) {
//			telefoneService.deleteByPacienteId(pacienteId);
//		} 
//		
//		for (int i = 0; i < pacienteRequest.getTelefones().size(); i++) {
//			BeanUtils.copyProperties(pacienteRequest.getTelefones().get(i), paciente.getTelefones().get(i), "telefoneId");
//		}
//		
//		if (pacienteRequest.getEnderecos().size() != paciente.getEnderecos().size()) {
//			enderecoService.deleteByPacienteId(pacienteId);
//		}
//		
//		for (int i = 0; i < pacienteRequest.getEnderecos().size(); i++) {
//			BeanUtils.copyProperties(pacienteRequest.getEnderecos().get(i), paciente.getEnderecos().get(i), "enderecoId");
//		}
//		
//		Paciente pacienteUpdate = pacienteRepository.save(paciente);
//		return PacienteMapper.toResponse(pacienteUpdate);
		return null;
	}
	

}
