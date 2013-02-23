package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Projeto extends Model {

	@Id
	public Long id;
	
	@Required(message="O campo deve ser preenchido.")
	public String titulo;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String resumo;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String introducao;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String fundamentacaoTeorica;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String justificativa;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String objetivos;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String metodologia;
	
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Required(message="O campo deve ser preenchido.")
	public String referencias;
	
	@ManyToOne
	public Edital edital;
	
	@ManyToOne
	public Usuario autor;
	
	@ManyToOne
	public Campus campus;
	
	
	@OneToMany
	public List<ProjetoAvaliado> progressoProjeto;
	
	
	
	public Projeto(){
		
		this.progressoProjeto = new ArrayList<ProjetoAvaliado>();
	}


	
	
	


	
	
	
	
	
	
	
	

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public String getFundamentacaoTeorica() {
		return fundamentacaoTeorica;
	}

	public void setFundamentacaoTeorica(String fundamentacaoTeorica) {
		this.fundamentacaoTeorica = fundamentacaoTeorica;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public Edital getEdital() {
		return edital;
	}

	public void setEdital(Edital edital) {
		this.edital = edital;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
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


	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	
	


	public List<ProjetoAvaliado> getProgressoProjeto() {
		return progressoProjeto;
	}

	public void setProgressoProjeto(List<ProjetoAvaliado> progressoProjeto) {
		this.progressoProjeto = progressoProjeto;
	}




	public static Finder<Long, Projeto> find = new Finder<Long, Projeto>(Long.class, Projeto.class);
}
