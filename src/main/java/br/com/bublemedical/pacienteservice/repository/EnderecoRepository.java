package br.com.bublemedical.pacienteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bublemedical.pacienteservice.domain.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	void deleteByPacientePacienteId(Long enderecoId);
}
