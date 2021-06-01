package com.paciente.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.paciente.domain.dto.EnderecoDto;
import com.paciente.domain.dto.TelefoneDto;
import com.paciente.domain.model.Endereco;
import com.paciente.domain.model.Paciente;
import com.paciente.domain.model.Telefone;
import com.paciente.domain.request.CartaoSaudeRequest;
import com.paciente.domain.request.PacienteRequest;
import com.paciente.domain.request.PutPacienteRequest;
import com.paciente.domain.response.PacienteResponse;

public interface PacienteService {
	
	Page<PacienteResponse> findAll(PageRequest pageable);
	
	PacienteResponse findById(Long pacienteId) throws Exception;

	PacienteResponse findByCpf(String cpf);
	
	PacienteResponse save(PacienteRequest pacienteRequest) throws Exception;
	
	PacienteResponse update(PacienteRequest pacienteRequest, Long pacienteId) throws Exception;
	
	void delete(Long pacienteId) throws Exception;

	List<Endereco> createAddress(@Valid List<EnderecoDto> enderecoRequest, Long pacienteId) throws Exception;

	List<Telefone> createTelefone(@Valid List<TelefoneDto> telefoneRequest, Long pacienteId) throws Exception;

	void createCartaoSaude(@Valid CartaoSaudeRequest cartaoSaudeRequest, Long pacienteId) throws Exception;

	PacienteResponse updateV2(PutPacienteRequest pacienteRequest, long pacienteId) throws Exception;
	
	Paciente findByPacienteId(Long pacienteId) throws Exception;

}
