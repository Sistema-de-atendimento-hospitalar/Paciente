package com.paciente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paciente.domain.enumerate.TipoTelefoneEnum;
import com.paciente.domain.response.TelefoneResponse;

@RestController
@CrossOrigin
public class BubleMedicalControler {

	@GetMapping(path = { "/v1/tipo-telefone" })
	public List<TelefoneResponse> findAllTipoTelefone() {
		return TipoTelefoneEnum.all();
	}

}
