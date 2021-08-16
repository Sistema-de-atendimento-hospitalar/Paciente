package br.com.bublemedical.pacienteservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.bublemedical.pacienteservice.domain.dto.EnderecoDto;
import br.com.bublemedical.pacienteservice.domain.dto.TelefoneDto;
import br.com.bublemedical.pacienteservice.domain.model.CartaoSaude;
import br.com.bublemedical.pacienteservice.domain.model.Endereco;
import br.com.bublemedical.pacienteservice.domain.model.Paciente;
import br.com.bublemedical.pacienteservice.domain.model.Telefone;
import br.com.bublemedical.pacienteservice.domain.request.CartaoSaudeRequest;
import br.com.bublemedical.pacienteservice.domain.request.PacienteRequest;
import br.com.bublemedical.pacienteservice.domain.request.PutPacienteRequest;
import br.com.bublemedical.pacienteservice.domain.response.PacienteResponse;
import br.com.bublemedical.pacienteservice.domain.response.TokenUserResponse;

public interface PacienteService {
	
	Page<PacienteResponse> findAll(PageRequest pageable);
	
	PacienteResponse findById(Long pacienteId);

	PacienteResponse findByCpf(String cpf);
	
	PacienteResponse save(PacienteRequest pacienteRequest);
	
	PacienteResponse update(PacienteRequest pacienteRequest, Long pacienteId);
	
	void delete(Long pacienteId);

	List<Endereco> createAddress(@Valid List<EnderecoDto> enderecoRequest, Long pacienteId);

	List<Telefone> createTelefone(@Valid List<TelefoneDto> telefoneRequest, Long pacienteId);

	CartaoSaude createCartaoSaude(@Valid CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId);

	PacienteResponse updateV2(PutPacienteRequest pacienteRequest, long pacienteId);
	
	Paciente findByPacienteId(Long pacienteId);
	
	TokenUserResponse verifyExistsCpf(String cpf);

}
