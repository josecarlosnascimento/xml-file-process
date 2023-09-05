package com.file.processor.relatorio.dto;

import java.util.List;

import com.file.processor.model.ValorCompra;
import com.file.processor.model.ValorGeracao;

import lombok.Data;

@Data
public class AgenteRelatorioDTO {
	
	private Long codigo;
	private List<ValorGeracao> vlGeracoes;
	private List<ValorCompra> vlCompras;
	
}
