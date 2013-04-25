package com.sigepi.professor.modelo;

public class Projeto {
	
	private int id;
	private String projeto;

	//Constantes com o nome das colunas do banco
	public static final String ID = "_id";
	public static final String PROJETO = "projeto";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

}
