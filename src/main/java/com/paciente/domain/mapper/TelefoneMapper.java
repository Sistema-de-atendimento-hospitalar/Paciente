package com.paciente.domain.mapper;

import org.modelmapper.ModelMapper;

import com.paciente.domain.model.Telefone;
import com.paciente.domain.request.TelefoneRequest;


public class TelefoneMapper {
	
	private TelefoneMapper() {}

	public static Telefone toModel(TelefoneRequest request) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, Telefone.class);
	}

}
