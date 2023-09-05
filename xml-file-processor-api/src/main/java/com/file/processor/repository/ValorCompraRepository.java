package com.file.processor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.processor.model.ValorCompra;

@Repository
public interface ValorCompraRepository extends JpaRepository<ValorCompra, Long>{

	List<ValorCompra> findByCompraId(Long idCompra);

	
}
