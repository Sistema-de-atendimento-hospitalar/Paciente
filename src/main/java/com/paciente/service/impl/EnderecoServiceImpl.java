package com.paciente.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paciente.domain.dto.EnderecoDto;
import com.paciente.domain.mapper.EnderecoMapper;
import com.paciente.domain.model.Endereco;
import com.paciente.domain.model.Paciente;
import com.paciente.repository.EnderecoRepository;
import com.paciente.service.EnderecoService;
import com.paciente.service.PacienteService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired private PacienteService pacienteService;

	@Override
	public List<Endereco> save(List<Endereco> enderecos) {
		return enderecoRepository.saveAll(enderecos);
	}
	
	public void deleteByPacienteId(Long pacienteId, Long enderecoId) throws Exception {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		enderecoRepository.deleteById(enderecoId);
	}

	@Override
	public List<Endereco> update(List<EnderecoDto> enderecoRequest, Long pacienteId) throws Exception {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		List<Endereco> enderecos = enderecoRequest.stream().map(EnderecoMapper::toModel).map(endereco -> {
			endereco.setPaciente(paciente);
			return endereco;
		})  .collect(Collectors.toList());
		return enderecoRepository.saveAll(enderecos);
	}

}
