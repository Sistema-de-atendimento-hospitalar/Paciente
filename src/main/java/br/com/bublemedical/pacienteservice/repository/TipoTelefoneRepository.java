package br.com.bublemedical.pacienteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bublemedical.pacienteservice.domain.model.TipoTelefone;

public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long>{

}
