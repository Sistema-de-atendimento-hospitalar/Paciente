package com.paciente.domain.mapper;

import org.modelmapper.ModelMapper;

import com.paciente.domain.model.Paciente;
import com.paciente.domain.response.PacienteResponse;


public class PacienteMapper {
	
	private PacienteMapper() {}

	public static PacienteResponse toResponse(Paciente paciente) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(paciente, PacienteResponse.class);
	}
}
