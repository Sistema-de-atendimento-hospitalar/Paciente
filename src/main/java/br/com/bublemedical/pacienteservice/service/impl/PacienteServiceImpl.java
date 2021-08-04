package br.com.bublemedical.pacienteservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.bublemedical.pacienteservice.domain.dto.EnderecoDto;
import br.com.bublemedical.pacienteservice.domain.dto.TelefoneDto;
import br.com.bublemedical.pacienteservice.domain.mapper.EnderecoMapper;
import br.com.bublemedical.pacienteservice.domain.mapper.PacienteMapper;
import br.com.bublemedical.pacienteservice.domain.mapper.TelefoneMapper;
import br.com.bublemedical.pacienteservice.domain.model.CartaoSaude;
import br.com.bublemedical.pacienteservice.domain.model.Endereco;
import br.com.bublemedical.pacienteservice.domain.model.Paciente;
import br.com.bublemedical.pacienteservice.domain.model.Telefone;
import br.com.bublemedical.pacienteservice.domain.request.CartaoSaudeRequest;
import br.com.bublemedical.pacienteservice.domain.request.PacienteRequest;
import br.com.bublemedical.pacienteservice.domain.request.PutPacienteRequest;
import br.com.bublemedical.pacienteservice.domain.response.PacienteResponse;
import br.com.bublemedical.pacienteservice.domain.response.TokenUserResponse;
import br.com.bublemedical.pacienteservice.exception.BusinessException;
import br.com.bublemedical.pacienteservice.repository.PacienteRepository;
import br.com.bublemedical.pacienteservice.service.CartaoSaudeService;
import br.com.bublemedical.pacienteservice.service.EnderecoService;
import br.com.bublemedical.pacienteservice.service.PacienteService;
import br.com.bublemedical.pacienteservice.service.TelefoneService;

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
			throw new BusinessException("CPF ou email já cadastrado", e);
		}
		return PacienteResponse.toDto(paciente);
	}

	@Override
	public PacienteResponse update(PacienteRequest pacienteRequest, Long pacienteId) throws Exception {
		Paciente paciente = findByPacienteId(pacienteId);
		BeanUtils.copyProperties(pacienteRequest, paciente, "pacienteId");
		
		try { 
			paciente = pacienteRepository.save(paciente);
		} catch (DataIntegrityViolationException e) {
			throw new BusinessException("CPF ou email já cadastrado", e);
		}

		return PacienteMapper.toResponse(paciente);
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

	@Override
	public TokenUserResponse verifyExistsCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
