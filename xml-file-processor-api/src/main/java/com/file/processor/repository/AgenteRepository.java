package com.file.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.processor.model.Agente;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long>{

}
