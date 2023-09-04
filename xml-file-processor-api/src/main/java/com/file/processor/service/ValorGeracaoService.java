package com.file.processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.processor.model.Geracao;
import com.file.processor.model.ValorGeracao;
import com.file.processor.repository.ValorGeracaoRepository;

@Service
public class ValorGeracaoService {
	
	@Autowired
	private ValorGeracaoRepository valorGeracaoRepository;
	
	public void inserirValorGeracao(Geracao geracao, List<Double> vlGeracao) {
		vlGeracao.forEach(ger -> {
			ValorGeracao vlGer = new ValorGeracao();
			vlGer.setGeracao(geracao);
			vlGer.setValor(ger);
			valorGeracaoRepository.save(vlGer);
		});
	}
}
