package com.file.processor.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.processor.RegiaoEnum;
import com.file.processor.model.Agente;
import com.file.processor.model.Compra;
import com.file.processor.model.Geracao;
import com.file.processor.model.ValorCompra;
import com.file.processor.model.ValorGeracao;
import com.file.processor.relatorio.dto.AgenteRelatorioDTO;
import com.file.processor.relatorio.dto.RelatorioDTO;
import com.file.processor.repository.AgenteRepository;
import com.file.processor.repository.CompraRepository;
import com.file.processor.repository.GeracaoRepository;
import com.file.processor.repository.ValorCompraRepository;
import com.file.processor.repository.ValorGeracaoRepository;

@Service
public class RelatorioService {
	
	@Autowired
	private ValorGeracaoRepository vlGeracaoRepository;;
	
	@Autowired
	private CompraRepository compraRepository;;
	
	@Autowired
	private ValorCompraRepository vlCompraRepository;;
	
	@Autowired
	private GeracaoRepository geracaoRepository;
	
	@Autowired
	private AgenteRepository agenteRepository;
	
	private List<ValorGeracao> vlGeracoes = new ArrayList<>();
	
	private List<ValorCompra> vlCompras = new ArrayList<>();
	
	private List<AgenteRelatorioDTO> agentesRelatorios = new ArrayList<>();
	
	private RelatorioDTO relat = new RelatorioDTO();
	
	private List<RelatorioDTO> relatorios = new ArrayList<>();
	
	public List<RelatorioDTO> emitirRelatorio() {
		
		List<RegiaoEnum> regioes = Arrays.asList(RegiaoEnum.values());
		
		regioes.stream().forEach(regi -> {
			List<Agente> agentes = agenteRepository.findAll();
			
			agentes.stream().forEach(agente ->{
				
				List<Geracao> geracoes = geracaoRepository.findByAgenteRegiaoIdAgAndAgenteRegiaoIdReg(agente.getId(), regi.getId());
				geracoes.stream().forEach(ger -> {
					vlGeracoes = vlGeracaoRepository.findByGeracaoId(ger.getId());
				});
				
				List<Compra> compras = compraRepository.findByAgenteRegiaoIdAgAndAgenteRegiaoIdReg(agente.getId(), regi.getId());
				compras.stream().forEach(cmp ->{
					vlCompras = vlCompraRepository.findByCompraId(cmp.getId());
				});
				
				AgenteRelatorioDTO agenteRelat = new AgenteRelatorioDTO();
				agenteRelat.setCodigo(agente.getId());
				agenteRelat.setVlCompras(vlCompras);
				agenteRelat.setVlGeracoes(vlGeracoes);
				
				
				agentesRelatorios.add(agenteRelat);
				this.relat = new RelatorioDTO();
				relat.setRegiao(regi);
				relat.setAgentesRelatorios(agentesRelatorios);
				relatorios.add(relat);
				
			});
		});
		System.out.println(relatorios);
		return relatorios;
	}
}
