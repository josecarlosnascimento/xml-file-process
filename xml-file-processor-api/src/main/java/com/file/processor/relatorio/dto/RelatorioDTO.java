package com.file.processor.relatorio.dto;

import java.util.List;

import com.file.processor.RegiaoEnum;

import lombok.Data;

@Data
public class RelatorioDTO {
	
	private RegiaoEnum regiao;
	private List<AgenteRelatorioDTO> agentesRelatorios;

}
