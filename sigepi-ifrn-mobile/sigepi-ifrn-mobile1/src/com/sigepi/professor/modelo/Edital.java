package com.sigepi.professor.modelo;

public class Edital {

	private int id;
	private int id_edital;
	private String titulo;
	
	//Constantes com o nome das colunas do banco
	public static final String ID = "_id";
	public static final String ID_EDITAL = "id_edital";
	public static final String TITULO = "titulo";

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_edital() {
		return id_edital;
	}
	public void setId_edital(int id_edital) {
		this.id_edital = id_edital;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
