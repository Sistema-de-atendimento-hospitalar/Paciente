package com.paciente.service;

import java.util.List;

import com.paciente.domain.model.Telefone;
import com.paciente.domain.request.TelefoneRequest;

public interface TelefoneService {
	public List<Telefone> save(List<Telefone> telefones);
	
	public void deleteByPacienteId(Long pacienteId, Long telefoneId);

	List<Telefone> update(List<TelefoneRequest> telefoneRequest, Long pacienteId) throws Exception;
}
