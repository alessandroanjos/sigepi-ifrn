package br.edu.ifrn.sigepi.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaMensagens {

	private List<Mensagem> erros;
	
	private List<Mensagem> sucessos;

	public ListaMensagens() {
		super();
		erros = new ArrayList<Mensagem>();
		sucessos = new ArrayList<Mensagem>();
	}
	
	public void addMensagemErro(Mensagem erro){
		erros.add(erro);
	}
	
	public void addMensagemSucesso(Mensagem suc){
		sucessos.add(suc);
	}
	
	public String getMensagensErro(){
		StringBuilder sb = new StringBuilder();
		Iterator<Mensagem> i = erros.iterator();
		while (i.hasNext()){
			sb.append(i.next().getMensagem());
			if (i.hasNext()){
				sb.append("\n");
			} 
		}
		erros.clear();
		
		return sb.toString();
	}
	
	public String getMensagensSucesso(){
		StringBuilder sb = new StringBuilder();
		Iterator<Mensagem> i = sucessos.iterator();
		while (i.hasNext()){
			sb.append(i.next().getMensagem());
			if (i.hasNext()){
				sb.append("\n");
			} 
		}
		sucessos.clear();
		
		return sb.toString();
	}
	
	public boolean contemErros(){
		return !erros.isEmpty();
	}
	
	public boolean contemSucessos(){
		return !sucessos.isEmpty();
	}
}
