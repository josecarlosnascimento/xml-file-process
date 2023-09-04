package com.file.processor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.processor.dto.GeracaoDTO;
import com.file.processor.model.AgenteRegiao;
import com.file.processor.model.Geracao;
import com.file.processor.repository.GeracaoRepository;

@Service
public class GeracaoService {
	
	@Autowired
	private GeracaoRepository geracaoRepository;
	
	@Autowired
	private ValorGeracaoService valorGeracaoService;
	
	public void inserirGeracao(AgenteRegiao regiao, GeracaoDTO geracaoDTO) {
		Geracao geracao = new Geracao();
		geracao.setAgenteRegiao(regiao);
		geracaoRepository.save(geracao);
		valorGeracaoService.inserirValorGeracao(geracao, geracaoDTO.getValores());
	}
}
