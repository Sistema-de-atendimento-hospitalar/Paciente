package com.paciente.domain.mapper;

import org.modelmapper.ModelMapper;

import com.paciente.domain.model.Endereco;
import com.paciente.domain.request.EnderecoRequest;

public class EnderecoMapper {
	
	private EnderecoMapper() {}

	public static Endereco toModel(EnderecoRequest request) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, Endereco.class);
	}

}
