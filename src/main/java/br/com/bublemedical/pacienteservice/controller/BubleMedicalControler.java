package br.com.bublemedical.pacienteservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bublemedical.pacienteservice.domain.enumerate.TipoTelefoneEnum;
import br.com.bublemedical.pacienteservice.domain.response.TelefoneResponse;

@RestController
@CrossOrigin
public class BubleMedicalControler {

	@GetMapping(path = { "/v1/tipo-telefone" })
	public List<TelefoneResponse> findAllTipoTelefone() {
		return TipoTelefoneEnum.all();
	}

}
