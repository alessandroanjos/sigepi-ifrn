package models;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	@Temporal(TemporalType.DATE)
	public Date dataCadastro;
	
    //@Required(message="O campo deve ser preenchido.")
	//public String campi;
	
	@Required(message="O campo deve ser preenchido.")
	public String agencia;
	
	@Required(message="O campo deve ser preenchido.")
	public String areaConhecimento;
	
	@ManyToMany
	public List<Professor> professor = new ArrayList<Professor>();
	
	@OneToMany
	public List<Bolsista> bolsista = new ArrayList<Bolsista>();
	
	@ManyToOne
	public Edital edital;
	
	@ManyToOne
	public Campus campus;
	
	
	public String getDataCadastro() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataCadastro);
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
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

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public List<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}

	public List<Bolsista> getBolsista() {
		return bolsista;
	}

	public void setBolsista(List<Bolsista> bolsista) {
		this.bolsista = bolsista;
	}

	

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Projeto() {
		// TODO Auto-generated constructor stub
	}
	
	public static Finder<Long, Projeto> find = new Finder<Long, Projeto>(Long.class, Projeto.class);
	
}
