package br.com.bublemedical.pacienteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bublemedical.pacienteservice.domain.model.CartaoSaude;

@Repository
public interface CartaoSaudeRepository extends JpaRepository<CartaoSaude, Long> {

}

      
