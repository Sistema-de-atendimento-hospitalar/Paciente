package com.paciente.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.paciente.request.PacienteRequest;
import com.paciente.response.PacienteDto;

public interface PacienteService {
	
	Page<PacienteDto> findAll(PageRequest pageable);
	
	PacienteDto findById(Long pacienteId) throws Exception;

	PacienteDto findByCpf(String cpf);
	
	PacienteDto save(PacienteRequest pacienteRequest) throws Exception;
	
	PacienteDto update(PacienteRequest pacienteRequest, Long pacienteId) throws Exception;
	
	void delete(Long pacienteId) throws Exception;

}
