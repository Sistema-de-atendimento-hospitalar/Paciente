package com.paciente.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.paciente.domain.request.CartaoSaudeRequest;
import com.paciente.domain.request.EnderecoRequest;
import com.paciente.domain.request.PacienteRequest;
import com.paciente.domain.request.PutPacienteRequest;
import com.paciente.domain.request.TelefoneRequest;
import com.paciente.domain.response.PacienteResponse;

public interface PacienteService {
	
	Page<PacienteResponse> findAll(PageRequest pageable);
	
	PacienteResponse findById(Long pacienteId) throws Exception;

	PacienteResponse findByCpf(String cpf);
	
	PacienteResponse save(PacienteRequest pacienteRequest) throws Exception;
	
	PacienteResponse update(PacienteRequest pacienteRequest, Long pacienteId) throws Exception;
	
	void delete(Long pacienteId) throws Exception;

	void createAddress(@Valid List<EnderecoRequest> enderecoRequest, Long pacienteId) throws Exception;

	void createTelefone(@Valid List<TelefoneRequest> telefoneRequest, Long pacienteId) throws Exception;

	void createCartaoSaude(@Valid CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId) throws Exception;

	PacienteResponse updateV2(PutPacienteRequest pacienteRequest, long pacienteId) throws Exception;

}
