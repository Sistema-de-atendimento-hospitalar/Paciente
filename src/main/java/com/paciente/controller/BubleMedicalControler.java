package com.paciente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paciente.domain.model.TipoTelefone;
import com.paciente.repository.TipoTelefoneRepository;

@RestController
@CrossOrigin
public class BubleMedicalControler {

	@Autowired
	private TipoTelefoneRepository tipoTelefoneRepository;

	@GetMapping(path = { "/v1/tipo-telefone" })
	public List<TipoTelefone> findAllTipoTelefone() {
		return tipoTelefoneRepository.findAll();
	}

}
