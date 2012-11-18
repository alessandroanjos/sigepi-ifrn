package models;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class Edital extends Model{
	@Id
	public Long idEdital;


	@Required (message="O campo deve ser preenchido.")
    public String nome;
	
	@Required (message="O campo deve ser preenchido.")
	public String descricao;
	
	@Required (message="O campo deve ser preenchido.")
	public String periodoInscricaoInicial;
	
	@Required (message="O campo deve ser preenchido.")
	public String periodoInscricaoFinal;
	
	
	@OneToMany
	public Projeto projeto;
	
	

   
    public Edital(){
    	
    }
	 
	 
	public Edital(Long idEdital, String descricao, String periodoInscricaoInicial, String periodoInscricaoFinal){
		this.idEdital = idEdital;
		this.descricao = descricao;
		this.periodoInscricaoInicial = periodoInscricaoInicial;
		this.periodoInscricaoFinal = periodoInscricaoFinal;
	}
	
		
	private static Set<Edital> editais ;
	static {
		editais = new HashSet<Edital>();
		editais.add(new Edital());
		
	}
	
	public static Finder<Long, Edital> find = new Finder<Long, Edital>(Long.class, Edital.class);

}
