package br.com.bublemedical.pacienteservice.service;

import java.util.List;

import br.com.bublemedical.pacienteservice.domain.dto.TelefoneDto;
import br.com.bublemedical.pacienteservice.domain.model.Telefone;

public interface TelefoneService {
	public List<Telefone> save(List<Telefone> telefones);
	
	public void deleteByPacienteId(Long pacienteId, Long telefoneId);

	List<Telefone> update(List<TelefoneDto> telefoneRequest, Long pacienteId);
}
