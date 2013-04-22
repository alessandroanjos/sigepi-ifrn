package com.sigepi.professor.modelo;

public class Projeto {
	
	private int id;
	private int id_projeto;
	private String projeto;
	
	
	//Constantes com o nome das colunas do banco
	public static final String ID = "_id";
	public static final String ID_PROJETO = "id_projeto";
	public static final String PROJETO = "projeto";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_projeto() {
		return id_projeto;
	}
	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

}
