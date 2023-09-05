package com.file.processor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.processor.model.Geracao;

@Repository
public interface GeracaoRepository extends JpaRepository<Geracao, Long>{
	
	List<Geracao> findByAgenteRegiaoIdAgAndAgenteRegiaoIdReg(Long idAgente, Long idRegiao);

}
