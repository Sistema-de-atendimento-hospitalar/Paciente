package com.paciente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paciente.domain.model.Telefone;
import com.paciente.repository.TelefoneRepository;
import com.paciente.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService{
	@Autowired
	private TelefoneRepository telefoneRepository;

	@Override
	public List<Telefone> save(List<Telefone> telefones) {
		return telefoneRepository.saveAll(telefones);
	}


}
