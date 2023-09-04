package com.file.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.processor.model.AgenteRegiao;

@Repository
public interface AgenteRegiaoRepository extends JpaRepository<AgenteRegiao, Long>{

}
