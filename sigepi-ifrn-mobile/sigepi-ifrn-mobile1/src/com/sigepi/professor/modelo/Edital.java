package com.sigepi.professor.modelo;

public class Edital {

	private int id;
	private String titulo;
	
	//Constantes com o nome das colunas do banco
	public static final String ID = "_id";
	public static final String TITULO = "titulo";

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
