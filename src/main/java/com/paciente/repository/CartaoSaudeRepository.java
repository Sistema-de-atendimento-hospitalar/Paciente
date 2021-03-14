package com.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paciente.domain.model.CartaoSaude;

@Repository
public interface CartaoSaudeRepository extends JpaRepository<CartaoSaude, Long> {

}

      
