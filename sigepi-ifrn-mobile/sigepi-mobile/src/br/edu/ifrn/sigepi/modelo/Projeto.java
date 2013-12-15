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

	public static final String PROJETO = "projeto";

	private String projeto;
	
	public Projeto() {
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
