package com.fotovoltaico.backend.repository;

import com.fotovoltaico.backend.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}