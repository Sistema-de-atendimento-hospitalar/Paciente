package br.com.bublemedical.pacienteservice.domain.mapper;

import org.modelmapper.ModelMapper;

import br.com.bublemedical.pacienteservice.domain.dto.EnderecoDto;
import br.com.bublemedical.pacienteservice.domain.model.Endereco;

public class EnderecoMapper {
	
	private EnderecoMapper() {}

	public static Endereco toModel(EnderecoDto request) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, Endereco.class);
	}

}
