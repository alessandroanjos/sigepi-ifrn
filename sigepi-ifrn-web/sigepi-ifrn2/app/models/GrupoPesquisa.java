package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * Classe que representa os grupos de pesquisa no sistema. 
 * @author Alessandro
 *
 */
@Entity
public class GrupoPesquisa extends Model {

	@Id
	public Long id;

	@Column(unique=true)
	@Required(message="O campo deve ser preenchido.")
	public String nome;
	
	@ManyToOne
	public Campus campus;
	
	@OneToMany
	public List<Usuario> usuarios;
	
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

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public static Finder<Long, GrupoPesquisa> find = new Finder<Long, GrupoPesquisa>(Long.class, GrupoPesquisa.class);

}
