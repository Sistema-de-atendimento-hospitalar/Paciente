package br.com.bublemedical.pacienteservice.service;

import java.util.List;

import br.com.bublemedical.pacienteservice.domain.dto.EnderecoDto;
import br.com.bublemedical.pacienteservice.domain.model.Endereco; 

public interface EnderecoService {

	public List<Endereco> save(List<Endereco> enderecos);
	
	public List<Endereco> update(List<EnderecoDto> enderecoRequest, Long pacienteId);
	
	public void deleteByPacienteId(Long pacienteId, Long enderecoId);
}
