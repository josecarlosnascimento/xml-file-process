package com.file.processor.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "REGIAO")
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String sigla;
	
	@OneToMany(mappedBy = "agenteRegiao")
	private List<Geracao> geracao;

	@OneToMany(mappedBy = "agenteRegiao")
	private List<Compra> compra;
	
	@ManyToMany
	@JoinTable(
			  name = "agente_regiao", 
			  joinColumns = @JoinColumn(name = "id_reg"), 
			  inverseJoinColumns = @JoinColumn(name = "id_ag"))
	private List<Agente> agentes;

}