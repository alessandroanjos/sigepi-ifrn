package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Campus extends Model{

	@Id
	public Long id;
	
	@Column(unique=true)
	@Required(message="O campo deve ser preenchido.")
	public String nome;
	
	@OneToMany
	public Usuario usuario;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	
	public static Finder<Long, Campus> find = new Finder<Long, Campus>(Long.class, Campus.class);
}
