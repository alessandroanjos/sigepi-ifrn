package models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;


@Entity
public class Projeto extends Model{

	
	@Id
	public Long id;
	
	public String nome;
	public String dataCadastro;
	public String numeroEdital;
	public String campus;
	public String agencia;
	public String areaConhecimento;
	
	@ManyToMany
	public List<Professor> professor = new ArrayList<Professor>();
	
	@OneToMany
	public List<Bolsista> bolsista = new ArrayList<Bolsista>();
	
	
	public Projeto() {
		// TODO Auto-generated constructor stub
	}
	
	
}
