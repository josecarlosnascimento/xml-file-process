package com.file.processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.processor.RegiaoEnum;
import com.file.processor.dto.RegiaoDTO;
import com.file.processor.model.Agente;
import com.file.processor.model.AgenteRegiao;
import com.file.processor.repository.AgenteRegiaoRepository;

@Service
public class AgenteRegiaoService {
	
	@Autowired
	private AgenteRegiaoRepository regiaoRepository;
	
	@Autowired
	private GeracaoService geracaoService;
	
	@Autowired
	private CompraService compraService;
	
	public void inserirRegioes(Agente agente, List<RegiaoDTO> regioes) {
		regioes.forEach(reg -> {
			AgenteRegiao agenteRegiao = new AgenteRegiao();
			agenteRegiao.setIdAg(agente.getId());
			agenteRegiao.setIdReg(RegiaoEnum.valueOf(reg.getSigla()).getId());
			regiaoRepository.save(agenteRegiao);
			geracaoService.inserirGeracao(agenteRegiao, reg.getGeracao());
			compraService.inserirCompra(agenteRegiao, reg.getCompra());
		});
	}
}
