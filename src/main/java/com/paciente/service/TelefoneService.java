package com.paciente.service;

import java.util.List;

import com.paciente.domain.dto.TelefoneDto;
import com.paciente.domain.model.Telefone;

public interface TelefoneService {
	public List<Telefone> save(List<Telefone> telefones);
	
	public void deleteByPacienteId(Long pacienteId, Long telefoneId);

	List<Telefone> update(List<TelefoneDto> telefoneRequest, Long pacienteId) throws Exception;
}
