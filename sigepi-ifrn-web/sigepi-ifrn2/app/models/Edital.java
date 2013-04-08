package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.URL;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Edital extends Model{

	@Id
	public Long id;
	
	@Column(unique=true)
	@Required(message="O campo deve ser preenchido.")
	public String titulo;
	
	@Lob
	@Required(message="O campo deve ser preenchido.")
	@Basic(fetch=FetchType.EAGER)
	public String descricao;
	
	@URL(message="Você deve informar uma URL válida.")
	@Required(message="O campo deve ser preenchido.")
	public String url;
	
	@Temporal(TemporalType.DATE)
	public Date	dataCadastro;
	
	@OneToOne(fetch=FetchType.EAGER)
	public Usuario autor;
	
	@OneToMany
	public List<Projeto> projetos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataCadastro() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataCadastro);
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public static Finder<Long, Edital> find = new Finder<Long, Edital>(Long.class, Edital.class);
}
