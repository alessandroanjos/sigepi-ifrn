package com.sigepi.professor.modelo;

public class ProjetoAvaliar {

	private int id;
	private String projetoAvaliar;

	//Constantes com o nome das colunas do banco
	public static final String ID = "_id";
	public static final String PROJETO_AVALIAR = "projetoAvaliar";

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjetoAvaliar() {
		return projetoAvaliar;
	}
	public void setProjetoAvaliar(String projetoAvaliar) {
		this.projetoAvaliar = projetoAvaliar;
	}
}
