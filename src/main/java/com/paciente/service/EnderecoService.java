package com.paciente.service;

import java.util.List;

import com.paciente.domain.dto.EnderecoDto;
import com.paciente.domain.model.Endereco; 

public interface EnderecoService {

	public List<Endereco> save(List<Endereco> enderecos);
	
	public List<Endereco> update(List<EnderecoDto> enderecoRequest, Long pacienteId) throws Exception;
	
	public void deleteByPacienteId(Long pacienteId, Long enderecoId) throws Exception;
}
