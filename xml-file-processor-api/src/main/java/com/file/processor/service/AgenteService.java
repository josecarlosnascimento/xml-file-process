package com.file.processor.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.file.processor.dto.AgentesDTO;
import com.file.processor.model.Agente;
import com.file.processor.repository.AgenteRepository;

@Service
public class AgenteService {
	
	@Autowired
	private AgenteRepository agenteRepository;
	
	@Autowired
	private AgenteRegiaoService regiaoService;
	
	public void processarArquivo(MultipartFile file) {
		
		File myFile;
		try {
			myFile = convert(file);
			var xml = new String(Files.readAllBytes(myFile.toPath()), Charset.defaultCharset());
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			xmlMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(Visibility.ANY));
			AgentesDTO agentes = xmlMapper.readValue(xml, AgentesDTO.class);
			removeConidentData(agentes);
			agentes.getAgentes().forEach(ag -> System.out.println(String.format("Agente código %s", ag.getCodigo())));
		
			inserirAgente(agentes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private File convert(MultipartFile file) throws IOException {
		File convertedFile = new File(file.getOriginalFilename());
		convertedFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convertedFile);
		fos.write(file.getBytes());
		fos.close();
		return convertedFile;
	}
	
	private void removeConidentData(AgentesDTO agentes) {
		agentes.getAgentes().stream().forEach(agente -> agente.getRegioes().stream().forEach(regiao -> regiao.getPrecoMedio().getValores().clear()));
	}
	
	public void inserirAgente(AgentesDTO agentesDTO) {
		agentesDTO.getAgentes().forEach(ag -> {
			Agente agente = new Agente();
			agente.setId(Long.parseLong(ag.getCodigo()));
			agente.setData(LocalDateTime.now());
			agenteRepository.save(agente);
			regiaoService.inserirRegioes(agente, ag.getRegioes());
		});
	}

}
