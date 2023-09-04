package com.file.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.processor.model.ValorCompra;

@Repository
public interface ValorCompraRepository extends JpaRepository<ValorCompra, Long>{

}
