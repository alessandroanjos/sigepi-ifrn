package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * Classe responsável pela representação dos bolsistas na base de dados.
 * @author Alessandro
 *
 */

@Entity
public class Bolsista extends Model{
	
	@Id
	public Long id;
	
	@Required(message="O campo deve ser preenchido.")
	public String nome;
	
	@Column(unique=true)
	@Required(message="O campo deve ser preenchido.")
	public Long matricula;
	
	@ManyToOne
	public Curso curso;
	
	@ManyToOne
	public Campus campus;
	
	@ManyToOne
	public Projeto projeto;

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

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	
	public static Finder<Long, Bolsista> find = new Finder<Long, Bolsista>(Long.class, Bolsista.class);

}
