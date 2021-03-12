package com.paciente.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.paciente.model.Paciente;
import com.paciente.repository.PacienteRepository;
import com.paciente.request.PacienteRequest;
import com.paciente.response.PacienteDto;
import com.paciente.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public PacienteDto findByCpf(String cpf) {
		Paciente paciente = pacienteRepository.findByCpf(cpf).orElseThrow(IllegalArgumentException::new);
		return PacienteDto.toDto(paciente);
	}

	@Override
	public Page<PacienteDto> findAll(PageRequest pageable) {
		return pacienteRepository.findAll(pageable).map(PacienteDto::toDto);
	}

	@Override
	public PacienteDto save(PacienteRequest pacienteRequest) throws Exception {
		Paciente paciente = PacienteRequest.toModel(pacienteRequest);
		try {
			paciente = pacienteRepository.save(paciente);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Error sistemico");
		}
		return PacienteDto.toDto(paciente);
	}

	@Override
	public PacienteDto update(PacienteRequest pacienteRequest, Long pacienteId) throws Exception {
		PacienteDto pacienteDto = findById(pacienteId);
		if (pacienteDto != null) {
			BeanUtils.copyProperties(pacienteRequest, pacienteDto, "pacienteId");
		}
		
		return null;
	}

	@Override
	public void delete(Long pacienteId) throws Exception {
		PacienteDto pacienteDto = findById(pacienteId);
		if (pacienteDto != null) {
			pacienteRepository.deleteById(pacienteId);
		}

	}

	@Override
	public PacienteDto findById(Long pacienteId) throws Exception {
		return pacienteRepository.findById(pacienteId).map(PacienteDto::toDto).orElseThrow(Exception::new);
	}

}
