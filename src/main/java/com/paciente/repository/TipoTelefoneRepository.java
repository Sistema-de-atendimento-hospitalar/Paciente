package com.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paciente.domain.model.TipoTelefone;

public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long>{

}
