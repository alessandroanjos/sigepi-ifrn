package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Classe responsável pelas áreas de conhecimento do sistema.
 *
 * @author Alessandro
 *
 */

@Entity
public class AreaConhecimento extends Model{

	@Id
	public Long id;

	@Column(unique=true)
	@Required(message="O campo deve ser preenchido.")
	public String nome;

	@OneToMany
	public List<Usuario> usuarios;

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
	
	public static Finder<Long, AreaConhecimento> find = new Finder<Long, AreaConhecimento>(Long.class, AreaConhecimento.class);
	
}
