package com.file.processor.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class AgentesDTO {
	
    @JacksonXmlProperty(localName = "agente")
    @JacksonXmlElementWrapper(useWrapping = false)
	private List<AgenteDTO> agentes;
	private Double versao;
}
