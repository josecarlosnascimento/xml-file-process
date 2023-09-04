package com.file.processor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.processor.dto.CompraDTO;
import com.file.processor.model.AgenteRegiao;
import com.file.processor.model.Compra;
import com.file.processor.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private ValorCompraService valorCompraService;
	
	public void inserirCompra(AgenteRegiao agenteRegiao, CompraDTO compraDTO) {
		Compra compra = new Compra();
		compra.setAgenteRegiao(agenteRegiao);
		compraRepository.save(compra);
		valorCompraService.inserirCompra(compra, compraDTO.getValores());
	}
}
