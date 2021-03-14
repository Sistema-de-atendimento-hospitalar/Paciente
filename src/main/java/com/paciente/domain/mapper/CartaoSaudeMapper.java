package com.paciente.domain.mapper;

import org.modelmapper.ModelMapper;

import com.paciente.domain.dto.CartaoSaudeDto;
import com.paciente.domain.model.CartaoSaude;
import com.paciente.domain.request.CartaoSaudeRequest;

public class CartaoSaudeMapper {

	private CartaoSaudeMapper() {}

	public static CartaoSaude toModel(CartaoSaudeRequest request) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, CartaoSaude.class);
	}
	
	public static CartaoSaudeDto toDto(CartaoSaude model) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(model, CartaoSaudeDto.class);
	}

}
