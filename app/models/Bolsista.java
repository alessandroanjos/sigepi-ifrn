package models;

import java.util.HashSet;
import java.util.Set;

public class Bolsista {

	public String nome;
	public String email;
	public String matricula;
	
	public Bolsista(){
		
	}
	
	public Bolsista(String nome, String email, String matricula){
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
	}
	
	public String toString() {
		return String.format("%s - %s - %s", nome, email, matricula);
	}
	
	
	private static Set<Bolsista> bolsistas;
	  
	  static {
	    bolsistas = new HashSet<Bolsista>();
	    bolsistas.add(new Bolsista("Alessandro", "sandro.adsc@gmail.com", "201114040444"));
	    bolsistas.add(new Bolsista("Aldrexler", "aldrexler@hotmail.com", "101010101010"));
	    bolsistas.add(new Bolsista("Richardson", "rixardon@hotmail.com", "201143432341"));
	    bolsistas.add(new Bolsista("Renata", "renata_jx@hotmail.com", "2012303030321"));
	    bolsistas.add(new Bolsista("Ney", "ney.fla@hotmail.com", "20101204398434"));
	  }
	  
	  public static Set<Bolsista> findAll() {
		  return new HashSet<Bolsista>(bolsistas); }
	  
	  public static void add(Bolsista bolsista) {
		  bolsistas.add(bolsista); }

}
