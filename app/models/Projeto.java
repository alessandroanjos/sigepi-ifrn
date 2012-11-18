package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class Projeto extends Model{

	
	@Id
	public Long id;
	
	
	
	@Required(message="O campo deve ser preenchido.")
	public String nome;
	
	@Required(message="O campo deve ser preenchido.")
	public String dataCadastro;
		
	@Required(message="O campo deve ser preenchido.")
	public String campus;
	
	@Required(message="O campo deve ser preenchido.")
	public String agencia;
	
	@Required(message="O campo deve ser preenchido.")
	public String areaConhecimento;
	
	@ManyToMany
	public List<Professor> professor = new ArrayList<Professor>();
	
	@OneToMany
	public List<Bolsista> bolsista = new ArrayList<Bolsista>();
	
	
	public Projeto() {
		// TODO Auto-generated constructor stub
	}
	
	public static Finder<Long, Projeto> find = new Finder<Long, Projeto>(Long.class, Projeto.class);
	
	
}
