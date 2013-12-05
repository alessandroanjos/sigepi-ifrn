package br.edu.ifrn.sigepi.util;

public class Response {

	private String mensagem;
	private Object resultado;
	
	public Response(){
		super();
		this.mensagem = "";
		this.resultado = null;
	}
	
	public Response(String mensagem, Object resultado) {
		super();
		this.mensagem = mensagem;
		this.resultado = resultado;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}
	
}
