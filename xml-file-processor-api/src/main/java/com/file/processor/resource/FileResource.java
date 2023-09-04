package com.file.processor.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.processor.service.AgenteService;

@RestController
@CrossOrigin("http://localhost:4200")
public class FileResource {
	
	@Autowired
	private AgenteService agenteService;

	@PostMapping("/upload")
	public ResponseEntity<Void> process(@RequestPart MultipartFile file) throws Exception {
		agenteService.processarArquivo(file);
		return null;
	}
}
