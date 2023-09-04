package com.file.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.processor.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{

}
