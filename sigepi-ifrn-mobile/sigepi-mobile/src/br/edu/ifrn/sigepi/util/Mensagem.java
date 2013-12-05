package br.edu.ifrn.sigepi.util;

public class Mensagem {
	
	private String mensagem;
	
	private boolean erro;

	public Mensagem(String mensagem, boolean erro) {
		super();
		this.mensagem = mensagem;
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isErro() {
		return erro;
	}

	public void setTipo(boolean erro) {
		this.erro = erro;
	}

}
