package br.com.bublemedical.pacienteservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bublemedical.pacienteservice.domain.dto.TelefoneDto;
import br.com.bublemedical.pacienteservice.domain.mapper.TelefoneMapper;
import br.com.bublemedical.pacienteservice.domain.model.Paciente;
import br.com.bublemedical.pacienteservice.domain.model.Telefone;
import br.com.bublemedical.pacienteservice.repository.TelefoneRepository;
import br.com.bublemedical.pacienteservice.service.PacienteService;
import br.com.bublemedical.pacienteservice.service.TelefoneService;

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

	public void deleteByPacienteId(Long pacienteId, Long telefoneId) {
		telefoneRepository.deleteByPacientePacienteId(pacienteId);
	}

	@Override
	public List<Telefone> update(List<TelefoneDto> telefoneRequest, Long pacienteId) throws Exception {
		Paciente paciente = pacienteService.findByPacienteId(pacienteId);
		List<Telefone> telefones = telefoneRequest.stream().map(TelefoneMapper::toModel).map(telefone -> {
			telefone.setPaciente(paciente);
			return telefone;
		}).collect(Collectors.toList());
		return telefoneRepository.saveAll(telefones);
	}

}
