package br.edu.ifrn.sigepi.modelo;

import java.io.Serializable;

/**
 * 
 * @author Alessandro
 * 
 */
public class ProjetoAvaliar implements Serializable {

	private static final long serialVersionUID = 1L;

	// Constantes com o nome das colunas do banco
	public static final String ID = "_id";
	public static final String PROJETO_AVALIAR = "projeto_avaliar";

	private int id;
	private String projetoAvaliar;
	
	public ProjetoAvaliar() {
	}

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
