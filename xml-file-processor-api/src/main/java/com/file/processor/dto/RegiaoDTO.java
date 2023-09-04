package com.file.processor.dto;
import lombok.Data;

@Data
public class RegiaoDTO {

	private String sigla;
	private GeracaoDTO geracao;
	private CompraDTO compra;
	private PrecoMedioDTO precoMedio;

}