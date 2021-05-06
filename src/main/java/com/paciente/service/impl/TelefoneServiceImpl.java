package com.paciente.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.paciente.domain.mapper.TelefoneMapper;
import com.paciente.domain.model.Paciente;
import com.paciente.domain.model.Telefone;
import com.paciente.domain.request.TelefoneRequest;
import com.paciente.repository.TelefoneRepository;
import com.paciente.service.PacienteService;
import com.paciente.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private PacienteService pacienteService;

	@Override
	public List<Telefone> save(List<Telefone> telefones) {
		return telefoneRepository.saveAll(telefones);
	}

	public void deleteByPacienteId(Long pacienteId) {
		telefoneRepository.deleteByPacientePacienteId(pacienteId);
	}

	@Override
	public List<Telefone> update(List<TelefoneRequest> telefoneRequest, Long pacienteId) throws Exception {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		List<Telefone> telefones = telefoneRequest.stream().map(TelefoneMapper::toModel).map(telefone -> {
			telefone.setPaciente(paciente);
			return telefone;
		}).collect(Collectors.toList());
		return telefoneRepository.saveAll(telefones);
	}

}
