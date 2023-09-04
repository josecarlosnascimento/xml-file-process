package com.file.processor;

public enum RegiaoEnum {
	
	SE(1,"SE"),
	S(2,"S"),
	NE(3,"NE"),
	N(4,"N");

	private long id;
	private String sigla;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	private RegiaoEnum(long id, String sigla) {
		this.id = id;
		this.sigla = sigla;
	}
	
}
