package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Classe responsável pelos cursos do IFRN no banco de dados.
 * @author Alessandro
 *
 */

@Entity
public class Curso extends Model{
	
	@Id
	public Long id;
	
	@Column(unique=true)
	@Required(message="O campo deve ser preenchido.")
	public String nome;
	
	@OneToMany
	public List<Bolsista> bolsistas;
	
	@OneToMany
	public List<Projeto> projetos;

	

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
	
	public List<Bolsista> getBolsistas() {
		return bolsistas;
	}

	public void setBolsistas(List<Bolsista> bolsistas) {
		this.bolsistas = bolsistas;
	}
	
	public static Finder<Long, Curso> find = new Finder<Long, Curso>(Long.class, Curso.class);
}
