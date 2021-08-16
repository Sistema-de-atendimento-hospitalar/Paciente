package br.com.bublemedical.pacienteservice.domain.mapper;

import org.modelmapper.ModelMapper;

import br.com.bublemedical.pacienteservice.domain.dto.CartaoSaudeDto;
import br.com.bublemedical.pacienteservice.domain.model.CartaoSaude;
import br.com.bublemedical.pacienteservice.domain.request.CartaoSaudeRequest;

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
