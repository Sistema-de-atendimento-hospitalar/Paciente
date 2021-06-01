package com.paciente.domain.mapper;

import org.modelmapper.ModelMapper;

import com.paciente.domain.dto.TelefoneDto;
import com.paciente.domain.model.Telefone;


public class TelefoneMapper {
	
	private TelefoneMapper() {}

	public static Telefone toModel(TelefoneDto request) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, Telefone.class);
	}

}
