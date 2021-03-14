package com.paciente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paciente.domain.model.Endereco;
import com.paciente.repository.EnderecoRepository;
import com.paciente.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public List<Endereco> save(List<Endereco> enderecos) {
		return enderecoRepository.saveAll(enderecos);
	}

}
