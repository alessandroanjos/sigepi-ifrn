package br.edu.ifrn.sigepi.modelo;

import java.io.Serializable;

/**
 * 
 * @author Alessandro
 * 
 */
public class Projeto implements Serializable, Comparable<Object> {

	private static final long serialVersionUID = 1L;
	
	public static String[] colunas = new String[] {Projeto.PROJETO};

	// Constantes com o nome das colunas do banco
	public static final String ID = "_id";
	public static final String PROJETO = "projeto";

	private int id;
	private String projeto;
	
	public Projeto() {
	}

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

	@Override
	public int compareTo(Object another) {
		Projeto p = (Projeto) another;
		return this.projeto.compareTo(p.projeto);
	}

}
