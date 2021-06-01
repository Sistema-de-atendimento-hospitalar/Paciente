package com.paciente.domain.mapper;

import org.modelmapper.ModelMapper;

import com.paciente.domain.dto.EnderecoDto;
import com.paciente.domain.model.Endereco;

public class EnderecoMapper {
	
	private EnderecoMapper() {}

	public static Endereco toModel(EnderecoDto request) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, Endereco.class);
	}

}
