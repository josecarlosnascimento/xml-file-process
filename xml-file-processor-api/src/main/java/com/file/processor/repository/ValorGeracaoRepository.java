package com.file.processor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.processor.model.ValorGeracao;

@Repository
public interface ValorGeracaoRepository extends JpaRepository<ValorGeracao, Long>{

	List<ValorGeracao> findByGeracaoId(Long idGeracao);
	
}
