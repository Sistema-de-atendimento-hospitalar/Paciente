package br.com.bublemedical.pacienteservice.domain.mapper;

import org.modelmapper.ModelMapper;

import br.com.bublemedical.pacienteservice.domain.dto.TelefoneDto;
import br.com.bublemedical.pacienteservice.domain.model.Telefone;


public class TelefoneMapper {
	
	private TelefoneMapper() {}

	public static Telefone toModel(TelefoneDto request) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, Telefone.class);
	}

}
