package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Campus extends Model{

	
	@Id
	public Long id;
	
	@Required(message="O campo deve ser preenchido.")
	public String nome;

	@OneToMany
	public List<Projeto> projetos;
	


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static Finder<Long, Campus> find = new Finder<Long, Campus>(Long.class, Campus.class);

}
