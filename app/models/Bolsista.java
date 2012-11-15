package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;

import play.data.validation.Constraints.Required;

@Entity
public class Bolsista {

	@Id
	public Long id;
	
	@Required(message="O campo deve ser preenchido.")
	public String nome;
	
	@Required
	@Email(message="O campo deve ser preenchido.")
	public String email;
	
	@Required(message="O campo deve ser preenchido.")
	public String matricula;
	
	@Required(message="O campo deve ser preenchido.")
	public String cpf;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static Set<Bolsista> getBolsistas() {
		return bolsistas;
	}

	public static void setBolsistas(Set<Bolsista> bolsistas) {
		Bolsista.bolsistas = bolsistas;
	}

	public Bolsista(){
		
	}
	
	public Bolsista(Long id, String nome, String email, String matricula, String cpf){
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.cpf = cpf;
	}
	
	public String toString() {
		return String.format("%s - %s - %s - s% - s%", id, nome, email, matricula, cpf);
	}
	 
	
	private static Set<Bolsista> bolsistas;
	  
	  static {
	    bolsistas = new HashSet<Bolsista>();
	    bolsistas.add(new Bolsista((long) 1, "Sandro", "sandro.adsc@gmail.com", "2012307846", "123456789-10"));
	    bolsistas.add(new Bolsista((long) 2, "Richarsdon", "rixardon@gmail.com", "201114040444", "223982332-10"));
	    bolsistas.add(new Bolsista((long) 3, "Aldrexler", "aldrexler@gmail.com", "201114040444", "123456789-10"));
	    bolsistas.add(new Bolsista((long) 4, "Renata", "renata_jx@gmail.com", "201114040444", "123456789-10"));
	    bolsistas.add(new Bolsista((long) 5, "Ney", "ney.fla@gmail.com", "201212122", "123456789-10"));
	  }
	  
	  public static Set<Bolsista> findAll() {
		  return new HashSet<Bolsista>(bolsistas); 
      }
	  
	  public static void add(Bolsista bolsista) {
		  bolsistas.add(bolsista); }

}
