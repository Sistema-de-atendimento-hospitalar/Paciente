package com.paciente.service;

import java.util.List;

import com.paciente.domain.model.Endereco;
import com.paciente.domain.request.EnderecoRequest; 

public interface EnderecoService {

	public List<Endereco> save(List<Endereco> enderecos);
	
	public List<Endereco> update(List<EnderecoRequest> enderecoRequest, Long pacienteId) throws Exception;
	
	public void deleteByPacienteId(Long pacienteId, Long enderecoId) throws Exception;
}
