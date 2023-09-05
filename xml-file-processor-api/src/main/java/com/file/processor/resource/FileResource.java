package com.file.processor.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.processor.relatorio.dto.RelatorioDTO;
import com.file.processor.service.AgenteService;
import com.file.processor.service.RelatorioService;

@RestController
@CrossOrigin("http://localhost:4200")
public class FileResource {
	
	@Autowired
	private AgenteService agenteService;
	
	@Autowired
	private RelatorioService relatorioService;
	
	@PostMapping("/upload")
	public ResponseEntity<Void> process(@RequestPart MultipartFile file) throws Exception {
		agenteService.processarArquivo(file);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/relatorio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RelatorioDTO>> emitirRelatorio(){
		
		List<RelatorioDTO> emitirRelatorio = relatorioService.emitirRelatorio();
		
		return ResponseEntity.ok(emitirRelatorio);
	}
}
