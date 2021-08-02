package br.com.bublemedical.pacienteservice.domain.mapper;

import org.modelmapper.ModelMapper;

import br.com.bublemedical.pacienteservice.domain.model.Paciente;
import br.com.bublemedical.pacienteservice.domain.response.PacienteResponse;


public class PacienteMapper {
	
	private PacienteMapper() {}

	public static PacienteResponse toResponse(Paciente paciente) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(paciente, PacienteResponse.class);
	}
}
