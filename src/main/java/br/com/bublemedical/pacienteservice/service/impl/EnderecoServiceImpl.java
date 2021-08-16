package br.com.bublemedical.pacienteservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bublemedical.pacienteservice.domain.dto.EnderecoDto;
import br.com.bublemedical.pacienteservice.domain.mapper.EnderecoMapper;
import br.com.bublemedical.pacienteservice.domain.model.Endereco;
import br.com.bublemedical.pacienteservice.domain.model.Paciente;
import br.com.bublemedical.pacienteservice.repository.EnderecoRepository;
import br.com.bublemedical.pacienteservice.service.EnderecoService;
import br.com.bublemedical.pacienteservice.service.PacienteService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired private PacienteService pacienteService;

	@Override
	public List<Endereco> save(List<Endereco> enderecos) {
		return enderecoRepository.saveAll(enderecos);
	}
	
	public void deleteByPacienteId(Long pacienteId, Long enderecoId) {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		enderecoRepository.deleteById(enderecoId);
	}

	@Override
	public List<Endereco> update(List<EnderecoDto> enderecoRequest, Long pacienteId) {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		List<Endereco> enderecos = enderecoRequest.stream().map(EnderecoMapper::toModel).map(endereco -> {
			endereco.setPaciente(paciente);
			return endereco;
		})  .collect(Collectors.toList());
		return enderecoRepository.saveAll(enderecos);
	}

}
