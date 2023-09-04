package com.file.processor.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class GeracaoDTO {

    @JacksonXmlProperty(localName = "valor")
    @JacksonXmlElementWrapper(useWrapping = false)
	private List<Double> valores;
	
}