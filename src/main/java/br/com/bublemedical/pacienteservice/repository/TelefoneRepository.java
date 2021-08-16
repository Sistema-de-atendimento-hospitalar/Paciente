package br.com.bublemedical.pacienteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bublemedical.pacienteservice.domain.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	
	void deleteByPacientePacienteId(Long pacienteId);

}
