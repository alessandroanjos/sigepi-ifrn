package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	public static Finder<Long, Curso> find = new Finder<Long, Curso>(Long.class, Curso.class);
}
