package com.sigepi.professor.modelo;

public class ProjetoStatusCampus {
	
	private int id;
	private String projetoStatusCampus;

	//Constantes com o nome das colunas do banco
	public static final String ID = "_id";
	public static final String PROJETO_STATUS_CAMPUS = "projetoStatusCampus";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjetoStatusCampus() {
		return projetoStatusCampus;
	}
	public void setProjetoStatusCampus(String projetoStatusCampus) {
		this.projetoStatusCampus = projetoStatusCampus;
	}

}
