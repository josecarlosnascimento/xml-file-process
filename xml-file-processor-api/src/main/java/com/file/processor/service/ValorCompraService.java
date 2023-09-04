package com.file.processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.processor.model.Compra;
import com.file.processor.model.ValorCompra;
import com.file.processor.repository.ValorCompraRepository;

@Service
public class ValorCompraService {
	
	@Autowired
	private ValorCompraRepository valorCompraRepository;
	
	public void inserirCompra(Compra compra, List<Double> vlGeracao) {
		vlGeracao.forEach(ger -> {
			ValorCompra vlGer = new ValorCompra();
			vlGer.setCompra(compra);
			vlGer.setValor(ger);
			valorCompraRepository.save(vlGer);
		});
	}
}
