package com.file.processor.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Agente {
	
	@Id
	private Long id;
	
	private LocalDateTime data;
	
    @ManyToMany(mappedBy = "agentes")
	private List<Regiao> regioes;
}
