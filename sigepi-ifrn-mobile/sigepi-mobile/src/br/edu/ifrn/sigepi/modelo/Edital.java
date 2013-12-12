package br.edu.ifrn.sigepi.modelo;

import java.io.Serializable;

/**
 * 
 * @author Alessandro
 *
 */
public class Edital implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static String[] colunas = new String[] {Edital.TITULO};
	
	public static final String TITULO = "titulo";

	private String titulo;
	
	public Edital() {
	}
	
	public Edital(String titulo){
		super();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
